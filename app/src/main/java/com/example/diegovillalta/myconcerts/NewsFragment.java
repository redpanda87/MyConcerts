package com.example.diegovillalta.myconcerts;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import com.parse.ParseQuery;
import com.parse.ParseObject;
import com.parse.ParseException;
import com.parse.FindCallback;
import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {


    private ListView mListView;
    private List<String> mNewsList;
    private List<Concert> mConcertList;


    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_news, container, false);

        mListView = (ListView) fragmentView.findViewById(R.id.listView);
        mNewsList = new ArrayList<String>();
        mConcertList = new ArrayList<Concert>();


        ParseQuery<ParseObject> query = ParseQuery.getQuery("concerts");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> concertList, ParseException e) {
                if (e == null) {
                    for (ParseObject parseObject : concertList) {

                        String title = (String) parseObject.get("title");
                        Log.d("title", title);
                        String link = (String) parseObject.get("link");
                        String imageLink = (String) parseObject.get("imageLink");

                        Concert concert = new Concert(title, link, imageLink);

                        mConcertList.add(concert);
                    }
                    mListView.setAdapter(new MyAdapter());

                } else {
                    // something went wrong
                }
            }
        });

      mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                      Concert concert = mConcertList.get(position);
                      String link = concert.getLink();
                      openBrowser(link);

          }
      });

      //

        return fragmentView;
    }




    public void openBrowser(String link){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
        startActivity(browserIntent);

    }


    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mConcertList.size();
        }

        @Override
        public Object getItem(int position) {
            return mConcertList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View rowView = getActivity().getLayoutInflater().inflate(R.layout.row,null);
            TextView textViewRow = (TextView) rowView.findViewById(R.id.textView);
            textViewRow.setText(mConcertList.get(position).getTitle());
            ImageView image = (ImageView)rowView.findViewById(R.id.imageView);
            Picasso.with(getActivity()).load(mConcertList.get(position).getImageLink()).into(image);

            return rowView;
        }
    }


}
