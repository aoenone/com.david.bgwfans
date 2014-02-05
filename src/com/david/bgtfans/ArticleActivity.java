package com.david.bgtfans;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.david.bgtfans.webviews.HiddenWiki;

/**
 * Created by david.hodge on 1/27/14.
 */
public class ArticleActivity extends SherlockFragmentActivity {

    Context mContext;
    ActionBar actionbar;
    String articleTitle;
    String articleDate;
    String articleContent;
    String articleLink;

    TextView articleTitleView;
    TextView articleDateView;
    TextView articleContentView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rss_article_view);
        mContext = this;

        actionbar = getSupportActionBar();
        actionbar.setDisplayShowTitleEnabled(false);
        actionbar.setDisplayHomeAsUpEnabled(true);

        articleTitleView = (TextView) findViewById(R.id.article_title);
        articleDateView = (TextView) findViewById(R.id.article_date);
        articleContentView = (TextView) findViewById(R.id.article_content);

        Bundle extras = getIntent().getExtras();
        articleTitle = extras.getString("article_title");
        articleDate = extras.getString("article_date");
        articleContent = extras.getString("article_content");
        articleLink = extras.getString("article_link");

        articleTitleView.setText(articleTitle);
        articleDateView.setText(removeLastChar(articleDate));
        articleContentView.setText(stripHtml(articleContent));

    }

    private static String removeLastChar(String str) {
        return str.substring(0, str.length() - 15);
    }

    private String stripHtml(String html) {
        return Html.fromHtml(html).toString();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getSupportMenuInflater();
        inflater.inflate(R.menu.rss_article_menu, (com.actionbarsherlock.view.Menu) menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.web_view:
                Intent aboutIntent = new Intent(ArticleActivity.this, HiddenWiki.class);
                aboutIntent.putExtra("wikiLink", articleLink);
                startActivity(aboutIntent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;
        }
        return true;
    }
}
