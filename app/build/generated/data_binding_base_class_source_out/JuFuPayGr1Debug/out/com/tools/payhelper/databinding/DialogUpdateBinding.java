// Generated by view binder compiler. Do not edit!
package com.tools.payhelper.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.tools.payhelper.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class DialogUpdateBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final TextView cancelBtn;

  @NonNull
  public final RelativeLayout loading;

  @NonNull
  public final TextView message;

  @NonNull
  public final TextView updateBtn;

  private DialogUpdateBinding(@NonNull RelativeLayout rootView, @NonNull TextView cancelBtn,
      @NonNull RelativeLayout loading, @NonNull TextView message, @NonNull TextView updateBtn) {
    this.rootView = rootView;
    this.cancelBtn = cancelBtn;
    this.loading = loading;
    this.message = message;
    this.updateBtn = updateBtn;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DialogUpdateBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DialogUpdateBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dialog_update, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DialogUpdateBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cancelBtn;
      TextView cancelBtn = rootView.findViewById(id);
      if (cancelBtn == null) {
        break missingId;
      }

      RelativeLayout loading = (RelativeLayout) rootView;

      id = R.id.message;
      TextView message = rootView.findViewById(id);
      if (message == null) {
        break missingId;
      }

      id = R.id.updateBtn;
      TextView updateBtn = rootView.findViewById(id);
      if (updateBtn == null) {
        break missingId;
      }

      return new DialogUpdateBinding((RelativeLayout) rootView, cancelBtn, loading, message,
          updateBtn);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}