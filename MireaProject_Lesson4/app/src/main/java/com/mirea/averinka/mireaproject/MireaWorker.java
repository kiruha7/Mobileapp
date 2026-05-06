package com.mirea.averinka.mireaproject;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MireaWorker extends Worker {

    public static final String KEY_RESULT = "result";

    public MireaWorker(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
    }

    @NonNull
    @Override
    public Result doWork() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            return Result.failure();
        }

        Data outputData = new Data.Builder()
                .putString(KEY_RESULT,
                        "Фоновая задача завершена. Студент: Аверин Кирилл Андреевич, группа: БСБО-50-24, номер в группе: 1")
                .build();

        return Result.success(outputData);
    }
}