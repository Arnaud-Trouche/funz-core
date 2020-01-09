package org.funz;

import java.io.File;

import org.funz.util.Disk;
import org.junit.Test;

/**
 *
 * @author richet
 */
public class DiskTest {

    public static void main(final String args[]) {
        org.junit.runner.JUnitCore.main(DiskTest.class.getName());
    }

    @Test
    public void testlistRecursiveFiles() {
        final File src_main_java = new File("src/main/java");
        final File[] lrs = Disk.listRecursiveFiles(src_main_java);
        boolean found = false;
        for (final File lr : lrs) {
            System.out.println(lr);
            if (lr.getName().equals("Disk.java")) {
                found = true;
            }
        }
        assert found : "Not all files found interface recursive list";
    }

    @Test
    public void testIsBinary() {
        final File java_src = new File("src/main/java/org/funz/util/Disk.java");
        assert !Disk.isBinary(java_src) : "bad binary inference";
        final File java_class = new File("bin/org/funz/util/Disk.class");
        assert Disk.isBinary(java_class) : "bad binary inference";
        final File R_src = new File("src/test/resources/branin.R");
        assert !Disk.isBinary(R_src) : "bad binary inference";
    }
}
