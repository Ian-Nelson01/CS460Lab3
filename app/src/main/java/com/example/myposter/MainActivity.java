package com.example.myposter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PostersListener{

    private Button buttonAddToWatchlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView postersRecyclerView = findViewById(R.id.postersRecyclerView);
        buttonAddToWatchlist = findViewById(R.id.buttonAddToWatchlist);

        //prepare data!
        List<Poster> posterList= new ArrayList<>();
        Poster SWep1 = new Poster();
        SWep1.image = R.drawable.swep1;
        SWep1.name = "The Phantom Menace";
        SWep1.createdBy = "Lucasfilm";
        SWep1.rating = 5f;
        SWep1.story = "Anakin is child.";
        posterList.add(SWep1);

        Poster SWep2 = new Poster();
        SWep2.image = R.drawable.swep2;
        SWep2.name = "Attack Of The Clones";
        SWep2.createdBy = "Lucasfilm";
        SWep2.rating = 5f;
        SWep2.story = "Anakin is a simp.";
        posterList.add(SWep2);

        Poster SWep3 = new Poster();
        SWep3.image = R.drawable.swep3;
        SWep3.name = "Revenge Of The Sith";
        SWep3.createdBy = "Lucasfilm";
        SWep3.rating = 5f;
        SWep3.story = "Anakin is Angy.";
        posterList.add(SWep3);

        Poster SWcw1 = new Poster();
        SWcw1.image = R.drawable.swcw1;
        SWcw1.name = "Clone Wars Season 1";
        SWcw1.createdBy = "Lucasfilm";
        SWcw1.rating = 2f;
        SWcw1.story = "Nothing really happens.";
        posterList.add(SWcw1);

        Poster SWcw2 = new Poster();
        SWcw2.image = R.drawable.swcw2;
        SWcw2.name = "Clone Wars Season 2";
        SWcw2.createdBy = "Lucasfilm";
        SWcw2.rating = 2f;
        SWcw2.story = "Cad steals babies.";
        posterList.add(SWcw2);

        Poster SWcw3 = new Poster();
        SWcw3.image = R.drawable.swcw3;
        SWcw3.name = "Clone Wars Season 3";
        SWcw3.createdBy = "Lucasfilm";
        SWcw3.rating = 4f;
        SWcw3.story = "Echo blows up.";
        posterList.add(SWcw3);

        Poster SWcw4 = new Poster();
        SWcw4.image = R.drawable.swcw4;
        SWcw4.name = "Clone Wars Season 4";
        SWcw4.createdBy = "Lucasfilm";
        SWcw4.rating = 4f;
        SWcw4.story = "Everyone commits warcrimes.";
        posterList.add(SWcw4);

        Poster SWcw5 = new Poster();
        SWcw5.image = R.drawable.swcw5;
        SWcw5.name = "Clone Wars Season 5";
        SWcw5.createdBy = "Lucasfilm";
        SWcw5.rating = 4f;
        SWcw5.story = "Maul ruins everything.";
        posterList.add(SWcw5);

        Poster SWcw6 = new Poster();
        SWcw6.image = R.drawable.swcw6;
        SWcw6.name = "Clone Wars Season 6";
        SWcw6.createdBy = "Lucasfilm";
        SWcw6.rating = 4f;
        SWcw6.story = "Fives beefs it.";
        posterList.add(SWcw6);

        Poster SWcw7 = new Poster();
        SWcw7.image = R.drawable.swcw7;
        SWcw7.name = "Clone Wars Season 7";
        SWcw7.createdBy = "Lucasfilm";
        SWcw7.rating = 4f;
        SWcw7.story = "Siege of Mandalore.";
        posterList.add(SWcw7);



        Poster SWep4 = new Poster();
        SWep4.image = R.drawable.swep4;
        SWep4.name = "A New Hope";
        SWep4.createdBy = "Lucasfilm";
        SWep4.rating = 5f;
        SWep4.story = "Luke flies ship.";
        posterList.add(SWep4);

        Poster SWep5 = new Poster();
        SWep5.image = R.drawable.swep5;
        SWep5.name = "The Empire Strikes Back";
        SWep5.createdBy = "Lucasfilm";
        SWep5.rating = 5f;
        SWep5.story = "Yoda trains Luke.";
        posterList.add(SWep5);

        Poster SWep6 = new Poster();
        SWep6.image = R.drawable.swep6;
        SWep6.name = "Return of the Jedi";
        SWep6.createdBy = "Lucasfilm";
        SWep6.rating = 5f;
        SWep6.story = "Luke fights Vader.";
        posterList.add(SWep6);



        final PosterAdapter posterAdapter = new PosterAdapter(posterList, this);
        postersRecyclerView.setAdapter(posterAdapter);

        buttonAddToWatchlist.setOnClickListener(new View.OnClickListener() {

            /**
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {

                List<Poster> selectPosters = posterAdapter.getSelectedPosters();

                StringBuilder posterNames = new StringBuilder();


                for(int i=0; i<selectPosters.size(); i++){
                    if(i==0){
                        posterNames.append(selectPosters.get(i).name);
                        }
                    else{
                        posterNames.append("\n").append(selectPosters.get(i).name);

                    }
                }
                Toast.makeText(MainActivity.this, posterNames.toString(), Toast.LENGTH_SHORT).show();
                    }
                });


    }


    /**
     * @param isSelected
     */
    @Override
    public void onPosterAction(Boolean isSelected) {
        if(isSelected){
            buttonAddToWatchlist.setVisibility(View.VISIBLE);
        }
        else{
            buttonAddToWatchlist.setVisibility(View.GONE);
        }

    }
}