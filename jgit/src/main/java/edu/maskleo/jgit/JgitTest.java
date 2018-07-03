package edu.maskleo.jgit;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JgitTest {

    public static void main(String[] args) {
        try {
            Repository rep = new FileRepository("E:\\learing_code\\github-api-jgit\\.git");
           /* String f = rep.getDirectory().getParent();
            File nFile = new File(f + "/" + buildFileName());
            nFile.createNewFile();*/
            Git git = new Git(rep);
            /*git.add().addFilepattern(nFile.getParent()).call();*/
            git.commit().setMessage(buildMessage()).call();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static String buildFileName() {
        return String.format("%s.txt", new SimpleDateFormat("yyyyMMddHH").format(new Date()));
    }

    private static String buildMessage() {
        return String.format("Update By JGit At %s", new SimpleDateFormat().format(new Date()));
    }
}
