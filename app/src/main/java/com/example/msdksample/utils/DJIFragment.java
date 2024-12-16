package com.example.msdksample.utils;

import android.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.example.msdksample.R;
import com.example.msdksample.data.consts;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

public class DJIFragment extends Fragment {
    protected Handler mainHandler = new Handler(Looper.getMainLooper());
    protected ArrayList<Integer> indexChosen = new ArrayList<Integer>(Arrays.asList(-1, -1, -1));

    private void updateTitle() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            int title = arguments.getInt(consts.MAIN_FRAGMENT_PAGE_TITLE, R.string.testing_tool);

        }
    }

    @Override
    public void  onViewCreated(View view,@Nullable Bundle saveInstanceState) {
        updateTitle();
    }

    public void initPopupNumberPicker(ArrayList<String> list, Runnable r) {
        NumberPicker numberPicker = (NumberPicker) findView
    }

    public void resetIndex() {
        indexChosen = new ArrayList<Integer>(Arrays.asList(-1, -1, -1));
    }

    public boolean isFragmentsShow() {
        return getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED);
    }

    public void openInputDialog(String text, String title, Consumer<String> onStrInput) {
        EditText inputServer = new EditText(getContext());
        inputServer.setText(text);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(title).setView(inputServer).setNegativeButton("CANCEL", null);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                onStrInput.accept(inputServer.getText().toString());
            }
        });
        builder.show();
    }
}
