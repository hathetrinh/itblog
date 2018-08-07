package com.trinhha.demo.itblog.cronjob;

import lombok.extern.java.Log;

@Log
public class CronJobMain {

    public static DictionaryFetchingData dictionaryFetchingData;

    public static void main(String[] args) {
        switch (args[0]) {
            case DictionaryFetchingData.jobName:
                dictionaryFetchingData = new DictionaryFetchingData();
                try {
                    dictionaryFetchingData.readFile();
                } catch (Exception e) {
                    log.warning(e.toString());
                }
                break;
        }
    }
}
