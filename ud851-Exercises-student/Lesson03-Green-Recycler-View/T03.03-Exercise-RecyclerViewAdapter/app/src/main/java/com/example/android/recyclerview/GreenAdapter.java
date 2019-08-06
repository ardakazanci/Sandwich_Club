/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * We couldn't come up with a good name for this class. Then, we realized
 * that this lesson is about RecyclerView.
 * <p>
 * RecyclerView... Recycling... Saving the planet? Being green? Anyone?
 * #crickets
 * <p>
 * Avoid unnecessary garbage collection by using RecyclerView and ViewHolders.
 * <p>
 * If you don't like our puns, we named this Adapter GreenAdapter because its
 * contents are green.
 */
// TODO (COMPLETED) From GreenAdapter, extend RecyclerView.Adapter<NumberViewHolder>
public class GreenAdapter extends RecyclerView.Adapter<GreenAdapter.NumberViewHolder>{

    // TODO (COMPLETED) Add a private int variable called mNumberItems

    private int mNumberItems; // Recyclerview içinde gösterilecek öğe sayısını tutacak.


    // TODO (COMPLETED) Create a constructor for GreenAdapter that accepts an int as a parameter for numberOfItems
    // TODO (COMPLETED) Store the numberOfItems parameter in mNumberItems

    // Adaptör yaratıldığında ilgili adet kadar görünüm yürütme işlemi gerçekleşecek.
    public GreenAdapter(int mNumberItems) {

        this.mNumberItems = mNumberItems;

    }

    // ViewHolder oluşturur. Önbelleğe alma işlemini ona bırakır.
    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.number_list_item;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        boolean shouldAttachParentImmediately = false;

        // Oluşturduğumuz görünüm şişirilip ViewHolder ' a gönderiliyor. Orada bunun üzerinden
        // view Elemanlarına veriler bağlanacak ve önbellekleme işlemi yapılacak
        View view = layoutInflater.inflate(layoutIdForListItem,parent,shouldAttachParentImmediately);
        // ViewHolder ' a ilgili görünümü gönderdik.
        NumberViewHolder numberViewHolder = new NumberViewHolder(view);

        return numberViewHolder;


    }

    // Verilerin görünüme bağlama işlemi Bind yardımcı metodunda yapılacak.
    @Override
    public void onBindViewHolder(NumberViewHolder holder, int position) {
            holder.bind(position);
            // Örneğin 5 inci ViewHolder ' a aktarılacak veri burada aktarılıyor fakat yardımcı metot kullandık.
    }

    @Override
    public int getItemCount() {
        return mNumberItems;
    }


    // TODO (COMPLETED) Override the onCreateViewHolder method
    // TODO (COMPLETED) Create and return a new NumberViewHolder within this method

    // TODO (COMPLETED) Override onBindViewHolder
    // TODO (COMPLETED) Within onBindViewHolder, call holder.bind and pass in the position

    // TODO (COMPLETED) Override getItemCount and return the number of items to display

    /**
     * Cache of the children views for a list item.
     */
    class NumberViewHolder extends RecyclerView.ViewHolder {

        // Will display the position in the list, ie 0 through getItemCount() - 1
        TextView listItemNumberView;

        /**
         * Constructor for our ViewHolder. Within this constructor, we get a reference to our
         * TextViews and set an onClickListener to listen for clicks. Those will be handled in the
         * onClick method below.
         *
         * @param itemView The View that you inflated in
         *                 {@link GreenAdapter#onCreateViewHolder(ViewGroup, int)}
         */
        public NumberViewHolder(View itemView) {
            super(itemView);

            listItemNumberView = (TextView) itemView.findViewById(R.id.tv_item_number);
        }

        /**
         * A method we wrote for convenience. This method will take an integer as input and
         * use that integer to display the appropriate text within a list item.
         *
         * @param listIndex Position of the item in the list
         */

        // Bu metodun yaptığı işlem alınan pozisyon değerine göre o elemana  setText olarak aktarmak.
        // Başka bir veride alınabilirdi.
        void bind(int listIndex) {
            listItemNumberView.setText(String.valueOf(listIndex));
        }
    }
}
