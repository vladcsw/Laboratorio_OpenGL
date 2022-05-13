package com.idnp.openglsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.graphics.PixelFormat;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import javax.microedition.khronos.opengles.GL10;

public class MainActivity extends AppCompatActivity {
    //private MainView mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);


//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        int ui = getWindow().getDecorView().getSystemUiVisibility();
//        ui = ui | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
//        getWindow().getDecorView().setSystemUiVisibility(ui);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
//        mView = new MainView(this);
//        setContentView(mView);


        // When working with the camera, it's useful to stick to one orientation.
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        // Next, we disable the application's title bar...
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // ...and the notification bar. That way, we can use the full screen.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Now let's create an OpenGL surface.
        GLSurfaceView glView = new GLSurfaceView(this);
        // To see the camera preview, the OpenGL surface has to be created translucently.
        // See link above.
        glView.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        glView.getHolder().setFormat(PixelFormat.TRANSLUCENT);
        // The renderer will be implemented in a separate class, GLView, which I'll show next.
        glView.setRenderer(new GLClearRenderer());
        // Now set this as the main view.
        setContentView(glView);

        // Now also create a view which contains the camera preview...
        CameraView cameraView = new CameraView(this);
        // ...and add it, wrapping the full screen size.

      getWindow().addContentView(cameraView, new WindowManager.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT));


    }

    @Override
    protected void onResume() {
        super.onResume();
        //mView.onResume();
    }

    @Override
    protected void onPause() {
        //mView.onPause();
        super.onPause();
    }

}
