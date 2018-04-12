package com.firex.media.ytsunofficial.Utilities;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class sRequestQueue {
    private static sRequestQueue INSTANCE;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;
    private static Context mContext;

    public static synchronized sRequestQueue getInstance(Context context) {
        if (INSTANCE == null)
            INSTANCE = new sRequestQueue(context);
        return INSTANCE;
    }

    private sRequestQueue(Context context) {
        mContext = context;
        this.mRequestQueue = getRequestQueue();

        mImageLoader = new ImageLoader(mRequestQueue,
                new ImageLoader.ImageCache() {
                    private final LruCache<String, Bitmap> cache = new LruCache<>(20);

                    @Override
                    public Bitmap getBitmap(String url) {
                        return cache.get(url);
                    }

                    @Override
                    public void putBitmap(String url, Bitmap bitmap) {
                        cache.put(url, bitmap);
                    }
                });
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null)
            mRequestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

    public ImageLoader getImageLoader() {
        return mImageLoader;
    }
}
