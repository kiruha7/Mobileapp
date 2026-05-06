package com.mirea.averinka.mireaproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

public class BackgroundTaskFragment extends Fragment {

    public BackgroundTaskFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_background_task, container, false);

        TextView textInfo = root.findViewById(R.id.textInfo);
        TextView textStatus = root.findViewById(R.id.textStatus);
        Button buttonRunTask = root.findViewById(R.id.buttonRunTask);

        textInfo.setText(
                "Контрольное задание\n" +
                        "Студент: Аверин Кирилл Андреевич\n" +
                        "Группа: БСБО-50-24\n" +
                        "Номер в группе: 1\n\n" +
                        "Нажмите кнопку для запуска фоновой задачи через Worker."
        );

        buttonRunTask.setOnClickListener(v -> {
            Constraints constraints = new Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    .build();

            OneTimeWorkRequest workRequest =
                    new OneTimeWorkRequest.Builder(MireaWorker.class)
                            .setConstraints(constraints)
                            .build();

            WorkManager.getInstance(requireContext()).enqueue(workRequest);

            textStatus.setText("Статус: задача поставлена в очередь");

            WorkManager.getInstance(requireContext())
                    .getWorkInfoByIdLiveData(workRequest.getId())
                    .observe(getViewLifecycleOwner(), workInfo -> {
                        if (workInfo == null) return;

                        textStatus.setText("Статус: " + workInfo.getState().name());

                        if (workInfo.getState() == WorkInfo.State.SUCCEEDED) {
                            String result = workInfo.getOutputData().getString(MireaWorker.KEY_RESULT);
                            textStatus.append("\n\n" + result);
                        }
                    });
        });

        return root;
    }
}