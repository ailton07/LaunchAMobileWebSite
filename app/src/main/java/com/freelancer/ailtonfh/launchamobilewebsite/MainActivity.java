package com.freelancer.ailtonfh.launchamobilewebsite;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Added
        // Usando intent
        /*
        Uri uri = Uri.parse("http://developer.android.com/intl/pt-br/reference/android/webkit/WebView.html");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
        */

        WebView myWebView = (WebView) findViewById(R.id.webView);
        //myWebView.setWebViewClient(new WebViewClient());
        myWebView.setWebViewClient(new MyWebViewClient());
        myWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                ProgressBar progress = (ProgressBar) findViewById(R.id.progressBar);
                progress.setProgress(newProgress);
                //super.onProgressChanged(view, newProgress);
                if(newProgress == 100){
                   progress.setVisibility(View.GONE);
                }
                else{
                    progress.setVisibility(View.VISIBLE);
                }
            }
        });

        WebSettings webSettings = myWebView.getSettings();

        // Configuracoes

        webSettings.setJavaScriptEnabled(true); // Habilita JavaScript
        webSettings.setDomStorageEnabled(true); // Habilita DOM storage API
        // Necessita que setAppCachePath(String) esteja setado
        //webSettings.setAppCacheEnabled(true);
        webSettings.setBuiltInZoomControls(true); // Mecanismo de zoom
        webSettings.setUseWideViewPort(true); // meta tag html viewport
        webSettings.setLoadWithOverviewMode(true);


        myWebView.loadUrl("http://developer.android.com/intl/pt-br/reference/android/webkit/WebView.html");
        //myWebView.loadUrl("https://www.gmail.com");


    }

    // Controle dos botões
    public void controllButtonFunction(View v)
    {
        Button button = (Button) v;

        if(button.getText().toString().equals("Next")){
            Log.e("Button", "Next");
            WebView myWebView = (WebView) findViewById(R.id.webView);
            myWebView.goForward();
        }
        else if(button.getText().toString().equals("Back")){
            Log.e("Button", "Back");
            WebView myWebView = (WebView) findViewById(R.id.webView);
            myWebView.goBack();
        }
        else if(button.getText().toString().equals("Atualizar")){
            WebView myWebView = (WebView) findViewById(R.id.webView);
            myWebView.reload();
        }
    }

    private class MyWebViewClient extends WebViewClient {

        @Override
        public void onLoadResource(WebView view, String url) {

            super.onLoadResource(view, url);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {

            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            return super.shouldOverrideUrlLoading(view, url);
        }
    }

}
