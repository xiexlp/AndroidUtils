package com.js.android.quick.swing.file;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.WatchEvent.Kind;

/**
 *
 * @author Apress
 */
class WatchRafaelNadal {

    public void watchRNDir(Path path) throws IOException, InterruptedException {
        try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
            path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);

            //start an infinite loop
            while (true) {

                //retrieve and remove the next watch key
                final WatchKey key = watchService.take();

                //get list of pending events for the watch key
                for (WatchEvent<?> watchEvent : key.pollEvents()) {

                    //get the kind of event (create, modify, delete)
                    final Kind<?> kind = watchEvent.kind();

                    //handle OVERFLOW event
                    if (kind == StandardWatchEventKinds.OVERFLOW) {
                        continue;
                    }                                        

                    //get the filename for the event
                    final WatchEvent<Path> watchEventPath = (WatchEvent<Path>) watchEvent;
                    final Path filename = watchEventPath.context();

                    //print it out
                    System.out.println(kind + " -> " + filename);
                    System.out.println(kind + " -> " + filename.toAbsolutePath().getFileName());
                }

                //reset the key
                boolean valid = key.reset();

                //exit loop if the key is not valid (if the directory was deleted, per example)
                if (!valid) {
                    break;
                }                
                
            }
        }
    }
}

public class Main2 {

    public static void main(String[] args) {

        //final Path path = Paths.get("C:/rafaelnadal");
        
        final Path path = Paths.get("E:\\jfinal\\beetl series\\jfinal_demo_for_maven\\src\\main\\webapp");
        
        WatchRafaelNadal watch = new WatchRafaelNadal();

        try {
            watch.watchRNDir(path);
        } catch (IOException | InterruptedException ex) {
            System.err.println(ex);
        }

    }
}
