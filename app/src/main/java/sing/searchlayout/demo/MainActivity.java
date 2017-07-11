package sing.searchlayout.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.Toast;

import sing.widget.SearchLayout;

public class MainActivity extends AppCompatActivity {

    SearchLayout searchLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchLayout = (SearchLayout) findViewById(R.id.search_layout);

        searchLayout.setOnSearchListener(new SearchLayout.OnSearchListener() {
            @Override
            public void onClick(String str, boolean isSearch) {
                Toast.makeText(MainActivity.this, str + "," + isSearch, Toast.LENGTH_SHORT).show();
            }
        });

        searchLayout.setOnEditorActionListener(new SearchLayout.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    Toast.makeText(MainActivity.this, "点击了按钮，actionId = " + actionId, Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

        searchLayout.setImeOptions(EditorInfo.IME_ACTION_SEND);
    }
}
