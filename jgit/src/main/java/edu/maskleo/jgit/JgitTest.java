package edu.maskleo.jgit;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.lib.Repository;

import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JgitTest {

    public static void main(String[] args) {
        try {
            for (int j = -365; j < 0; j++) {
                if (!isR()) {
                    continue;
                }
                java.util.Random r = new Random();
                int kd = r.nextInt(100);
                for(int k = 0;k<kd;k++){
                    Calendar c = Calendar.getInstance();
                    c.add(Calendar.DAY_OF_MONTH, j);
                    editText();
                    Repository rep = new FileRepository("E:\\learing_code\\github-api-jgit\\.git");
                    Git git = new Git(rep);
                    PersonIdent defaultCommitter = new PersonIdent(git.getRepository());
                    PersonIdent committer = new PersonIdent(defaultCommitter, c.getTime());
                    git.commit().setMessage("auto commit").setCommitter(committer).call();
                    System.out.println(j);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void editText() throws Exception {
        String path = "E:\\learing_code\\github-api-jgit\\2018070317.txt";
        RandomAccessFile raf = new RandomAccessFile(path, "rw");
        raf.writeBytes("auto commit" + System.nanoTime());
        raf.close();
    }

    private static String buildMessage() {
        return String.format("Update By JGit At %s", new SimpleDateFormat().format(new Date()));
    }

    private static boolean isR() {
        java.util.Random r = new Random();
        int i = r.nextInt(7);
        return i == 0;
    }
}
