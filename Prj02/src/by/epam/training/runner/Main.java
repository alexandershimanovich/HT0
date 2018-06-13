package by.epam.training.runner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import by.epam.training.bean.track.TrackManager;
import by.epam.training.logic.Catalog;
import by.epam.training.logic.CheckSum;
import by.epam.training.logic.Html;

public class Main {
	
	private static final String PATH_TO_SAVE_ORIGINAL = "D:/original.html";
	private static final String PATH_TO_SAVE_DUBLICATE = "D:/dublicate.html";
	
    public static void main(String[] args) {
        File[] files = new File[args.length];
        HashSet<String> set = new HashSet<>();
        if (args.length == 0) {
            System.out.println("Should be input at least one path to directory");
            System.exit(-1);
        } else {

            for (int i = 0; i < args.length; i++) {
                files[i] = new File(args[i]);
            }
        }

        Catalog catalogMP3 = new Catalog(".mp3");
        try {
            set = catalogMP3.searcher(files);

        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String x : set) {

            TrackManager.addTrack(x);

        }
        new Html().createHtmlFile(PATH_TO_SAVE_ORIGINAL, TrackManager.getAllSongsMap());
        HashMap<String, List<String>> sumDuplicatesList = new HashMap<>();
        for (String x : set) {
            String sum = CheckSum.getCheckSum(x);
            if (!sumDuplicatesList.containsKey(sum)) {
                sumDuplicatesList.put(sum, new ArrayList<>());
                sumDuplicatesList.get(sum).add(x);
            } else {
                sumDuplicatesList.get(sum).add(x);
            }
        }

        new Html().createSumDuplicateFile(PATH_TO_SAVE_DUBLICATE, sumDuplicatesList);
    }
}
