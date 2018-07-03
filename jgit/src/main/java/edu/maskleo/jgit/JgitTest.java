package edu.maskleo.jgit;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JgitTest {
    public static void main(String[] args) {
        try {
            Repository rep = new FileRepository("E:\\learing_code\\github-api-jgit\\.git");
            Git git = new Git(rep);
            git.commit().setMessage(buildMessage()).call();
            //git.pull().setCredentialsProvider(new UsernamePasswordCredentialsProvider("myname", "password")).call();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static String buildMessage() {
        return String.format("Update By JGit At %s", new SimpleDateFormat().format(new Date()));
    }
}
