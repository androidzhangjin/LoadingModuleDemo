package com.zj.loadinglib;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zj.loadingmoduledemo.DensityUtil;

public class LoadingManager {
    private Context context;
    private LoadingManager(Context context) {
        this.context = context;
    }

    private volatile static LoadingManager loadingManager;
    public static LoadingManager getInstance(Context context) {
        if (loadingManager == null) {
            synchronized (LoadingManager.class) {
                if (loadingManager == null) {
                    loadingManager = new LoadingManager(context);
                }
            }
        }
        return loadingManager;
    }

    public Dialog mDialog;

    public void initLoadDialog(String content) {
        if (mDialog == null) {
            mDialog = getLoadingDialog(content);
            mDialog.setCancelable(false);
        } else {
            dialogTvContent.setText(content);
        }
        if (!mDialog.isShowing()) {
            mDialog.show();
        }
    }

    TextView dialogTvContent;

    private Dialog getLoadingDialog(String content) {
        Dialog dialog = new Dialog(context, R.style.AlertDialogStyle);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_loading, null);
        dialogTvContent = view.findViewById(R.id.tv_note);
        if (TextUtils.isEmpty(content)) {
            dialogTvContent.setVisibility(View.GONE);
        } else {
            dialogTvContent.setText(content);
        }
        dialog.setContentView(view, new ViewGroup.LayoutParams(DensityUtil.dp2px(context, 96), DensityUtil.dp2px(context, 96)));
        return dialog;
    }

    public void dismissLoadDialog() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }

}
