package com.tomdeveloper.pokeapi.home_activity.trainerProfile.ui

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.core.content.ContextCompat
import com.tomdeveloper.pokeapi.R
import com.tomdeveloper.pokeapi.commons.BaseFragment
import java.io.File
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors


class TakePhotoProfileFragment : BaseFragment() {

    private var imageCapture: ImageCapture? = null
    private lateinit var viewFinder: PreviewView
    private lateinit var outputDirectory: File
    private lateinit var cameraExecutor: ExecutorService
    private lateinit var btntakepicture: ImageButton

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return layoutInflater.inflate(R.layout.fragment_take_photo_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewFinder = view.findViewById(R.id.preView)
        btntakepicture = view.findViewById(R.id.btn_takephoto_takephotofragment)
        // hilo de la camara (destruido al cerrar el fragment)
        cameraExecutor = Executors.newSingleThreadExecutor()
        // obtiene/crea el directorio donde se almacenara la foto
        outputDirectory = getOutputDirectory()
        // abre la camara y previsualiza lo que capta
        startCamera()
        // listener para capturar la foto
        btntakepicture.setOnClickListener {
            takePhoto()
        }
    }


    private fun takePhoto() {

        // Get a stable reference of the modifiable image capture use case
        val imageCapture = imageCapture ?: return



        // Create time-stamped output file to hold the image
        val photoFile = File(
            outputDirectory,UUID.randomUUID().toString()+".jpg")

        // Create output options object which contains file + metadata
        val outputOptions = ImageCapture.OutputFileOptions.Builder(photoFile).build()

        // Set up image capture listener, which is triggered after photo has
        // been taken
        imageCapture.takePicture(
            outputOptions, ContextCompat.getMainExecutor(context), object : ImageCapture.OnImageSavedCallback {
                override fun onError(exc: ImageCaptureException) {
                    Log.e(TAG, "Error al capturar la foto: ${exc.message}", exc)
                    back()
                }

                override fun onImageSaved(output: ImageCapture.OutputFileResults) {
                    val savedUri = Uri.fromFile(photoFile)
                    val msg = "Foto guardada: ${savedUri.path}"
                    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
                    Log.d(TAG, msg)
                    back()
                }
            })
    }

    // abre la camara con sus listener para poder previsualizar lo que capta
    private fun startCamera() {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(requireContext())
        cameraProviderFuture.addListener(Runnable {
            // Used to bind the lifecycle of cameras to the lifecycle owner
            val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()

            // Preview
            val preview = Preview.Builder()
                .build()
                .also {
                    it.setSurfaceProvider(viewFinder.createSurfaceProvider())
                }

            imageCapture = ImageCapture.Builder()
                .build()

            // Dado que es un selfie activo la camara delantera por defecto (no he dado posibilidad de cambiar)
            val cameraSelector = CameraSelector.DEFAULT_FRONT_CAMERA

            try {
                // Unbind use cases before rebinding
                cameraProvider.unbindAll()

                // Bind use cases to camera
                cameraProvider.bindToLifecycle(
                    this, cameraSelector, preview, imageCapture)

            } catch(exc: Exception) {
                Log.e(TAG, "Use case binding failed", exc)
            }

        }, ContextCompat.getMainExecutor(context))


    }

    // mata al hilo de la camara al destruirse el fragment (importante sino da error y se sale de la app)
    override fun onDestroy() {
        super.onDestroy()
        cameraExecutor.shutdown()
    }

    // solo muestra el log si hay error
    companion object {
        private const val TAG = "CameraXBasic"
    }

    private fun back(){
        // no uso el navigation para que no me guarde la pila de salidas y entradas a fragment
        // ya que si entro y salgo de la camara luego al darle hacia atras vuelvo a la camara.. y salgo XD !
        requireActivity().onBackPressed()
    }

    // obtengo el directorio raiz de mi app, si no exite se crea
    private fun getOutputDirectory(): File {
        val mediaDir = requireActivity().externalMediaDirs.firstOrNull()?.let {
            File(it, resources.getString(R.string.app_name)).apply { mkdirs() } }
        return if (mediaDir != null && mediaDir.exists())
            mediaDir else requireActivity().filesDir
    }

}