package com.example.android.lublin;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter{
private Context mContext;
    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;

    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_historical_places);
        } else if (position == 1) {
            return mContext.getString(R.string.category_food);
        }else if (position == 2) {
            return mContext.getString(R.string.category_shopping);
        } else {
                return mContext.getString(R.string.category_events);
            }
        }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new HistoricalPlaces();
        }
        else if (position == 1) {
           return new Food();
        } else if (position == 2) {
            return new Shop();
        } else {
            return new Events();
        }
    }
    @Override
    public int getCount() {
        return 4;
    }


    }





