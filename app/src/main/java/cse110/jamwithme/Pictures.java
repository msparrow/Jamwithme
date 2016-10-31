package cse110.jamwithme;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
// need this to create the method onCreate
import android.os.Bundle;
// need this for the listener
import android.content.Intent;
import android.provider.MediaStore;
import android.net.Uri;
/**
 * Created by mayabello on 10/30/16.
 */

public class Pictures extends AppCompatActivity implements View.OnClickListener{
    // static because its going to remain constant
    private static final int RESULT_LOAD_IMAGE = 1;
    ImageView imageView, extraPics;
    Button bAddImage;


    @Override
    // onCreate intializes activity
    protected void onCreate(Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);
        setContentView(R.layout.activity_user_profile);

        // pictures must be of type ImageView, we are casting
        imageView = (ImageView) findViewById(R.id.profilePic);
        extraPics = (ImageView) findViewById(R.id.extraPics);
        bAddImage = (Button) findViewById(R.id.bAddImage);

        // need something to listen to the clicks
        imageView.setOnClickListener(this);
        extraPics.setOnClickListener(this);
        bAddImage.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.profilePic:
                // opens up a user's gallery
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.
                                                                    EXTERNAL_CONTENT_URI);
                // get the results of what pic they selected
                startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);
                break;
            case R.id.extraPics:

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && data != null) {
            // display image that has been selected, Uri means uniform
            // get address of image
            Uri selectedImage = data.getData();
            imageView.setImage(selectedImage);
        }
    }
}
