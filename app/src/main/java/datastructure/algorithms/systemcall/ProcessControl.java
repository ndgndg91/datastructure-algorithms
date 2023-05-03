package datastructure.algorithms.systemcall;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class ProcessControl {

    public static void main(String[] args) throws IOException {
        System.out.println("create ndg-process");
        ProcessBuilder builder = new ProcessBuilder(List.of("ls", "-alt", "."));
        Process p = builder.start();
        ProcessHandle.Info info = p.info();
        System.out.println("main-process id : " + ProcessHandle.current().pid());
        System.out.println("ndg-process id : " + p.pid());
        p.destroy();
        System.out.println("destroy ndg-process");

        infoOfLiveProcesses();
    }

    private static void infoOfLiveProcesses() {
        Stream<ProcessHandle> liveProcesses = ProcessHandle.allProcesses();
        liveProcesses.filter(ProcessHandle::isAlive)
                .forEach(ph -> {
                    System.out.println("PID: " + ph.pid());
                    System.out.println("Instance: " + ph.info().startInstant());
                    System.out.println("User: " + ph.info().user());
                });
    }
}
