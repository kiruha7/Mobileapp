package com.mirea.averinka.mireaproject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class WebViewFragment extends Fragment {

    private WebView webView;
    private EditText editTextUrl;
    private Button buttonOpen;

    public WebViewFragment() {
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_web_view, container, false);

        webView = root.findViewById(R.id.webView);
        editTextUrl = root.findViewById(R.id.editTextUrl);
        buttonOpen = root.findViewById(R.id.buttonOpen);

        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setJavaScriptEnabled(true);

        webView.loadUrl("https://www.mirea.ru");

        buttonOpen.setOnClickListener(v -> {
            String url = editTextUrl.getText().toString().trim();

            if (TextUtils.isEmpty(url)) {
                url = "https://www.mirea.ru";
            }

            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "https://" + url;
            }

            webView.loadUrl(url);
        });

        return root;
    }
}