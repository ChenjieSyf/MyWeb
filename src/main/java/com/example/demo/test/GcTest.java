package com.example.demo.test;

/**
 * @author chenjie15
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/5/15 14:12
 */
public class GcTest {

    private static final int _1MB = 1024*1024;
    public static void main(String[] args) {
       //   new GcTest().EdenMinorGc();
       // testPretenureSizeThreshold();
        testTenuringThreshold();
    }

    /**
     *VM参数:-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
     */

    public void EdenMinorGc(){
            byte[]allocation1,allocation2,allocation3,allocation4;
            allocation1=new byte[2*_1MB];
            allocation2=new byte[2*_1MB];
            allocation3=new byte[2*_1MB];
           //出现一次Minor GC
            allocation4=new byte[4*_1MB];
    }



    /**
     *VM参数:-verbose:gc-Xms20M-Xmx20M-Xmn10M-XX:+PrintGCDetails-XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
     */
    public static void testPretenureSizeThreshold(){
        byte[]allocation;
        //直接分配在老年代中
        allocation=new byte[4*_1MB];
    }
    /**
     * Heap
     def new generation total 9216K,used 671K[0x029d0000,0x033d0000,0x033d0000)
     eden space 8192K,8%used[0x029d0000,0x02a77e98,0x031d0000)
     from space 1024K,0%used[0x031d0000,0x031d0000,0x032d0000)
     to space 1024K,0%used[0x032d0000,0x032d0000,0x033d0000)
     tenured generation total 10240K,used 4096K[0x033d0000,0x03dd0000,0x03dd0000)
     the space 10240K,40%used[0x033d0000,0x037d0010,0x037d0200,0x03dd0000)
     compacting perm gen total 12288K,used 2107K[0x03dd0000,0x049d0000,0x07dd0000)
     the space 12288K,17%used[0x03dd0000,0x03fdefd0,0x03fdf000,0x049d0000)
     No shared spaces configured.
     */




/**
 *VM参数:-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1
 * -XX:+PrintTenuringDistribution
 */
    @SuppressWarnings("unused")
    public static void testTenuringThreshold(){
        byte[]allocation1,allocation2,allocation3;
        allocation1=new byte[_1MB/4];
       //什么时候进入老年代取决于XX:MaxTenuringThreshold设置
        allocation2=new byte[4*_1MB];
        allocation3=new byte[4*_1MB];
        allocation3=null;
        allocation3=new byte[4*_1MB];
    }
    /**
     * [GC[DefNew
     Desired Survivor size 524288 bytes,new threshold 1（max 1）
     -age 1：414664 bytes，414664 total ：4859K-＞404K（9216K），0.0065012 secs]4859K-＞4500K（19456K），0.0065283 secs][Times：user=0.02 sys=0.00，real=0.02 secs]
     [GC[DefNew
     Desired Survivor size 524288 bytes,new threshold 1（max 1）
     ：4500K-＞0K（9216K），0.0009253 secs]8596K-＞4500K（19456K），0.0009458 secs][Times：user=0.00 sys=0.00，real=0.00 secs]
     Heap
     def new generation total 9216K,used 4178K[0x029d0000，0x033d0000，0x033d0000）
     eden space 8192K，51%used[0x029d0000，0x02de4828，0x031d0000）
     from space 1024K，0%used[0x031d0000，0x031d0000，0x032d0000）
     to space 1024K，0%used[0x032d0000，0x032d0000，0x033d0000）
     tenured generation total 10240K,used 4500K[0x033d0000，0x03dd0000，0x03dd0000）
     the space 10240K，43%used[0x033d0000，0x03835348，0x03835400，0x03dd0000）
     compacting perm gen total 12288K,used 2114K[0x03dd0000，0x049d0000，0x07dd0000）
     the space 12288K，17%used[0x03dd0000，0x03fe0998，0x03fe0a00，0x049d0000）

     No shared spaces configured. 以MaxTenuringThreshold=15参数来运行的结果：
     [GC[DefNew
     Desired Survivor size 524288 bytes,new threshold 15（max 15）
     -age 1：414664 bytes，414664 total ：4859K-＞404K（9216K），0.0049637 secs]4859K-＞4500K（19456K），0.0049932 secs][Times：user=0.00 sys=0.00，real=0.00 secs]
     [GC[DefNew
     Desired Survivor size 524288 bytes,new threshold 15（max 15）
     -age 2：414520 bytes，414520 total ：4500K-＞404K（9216K），0.0008091 secs]8596K-＞4500K（19456K），0.0008305 secs][Times：user=0.00 sys=0.00，real=0.00 secs]
     Heap
     def new generation total 9216K,used 4582K[0x029d0000，0x033d0000，0x033d0000）
     eden space 8192K，51%used[0x029d0000，0x02de4828，0x031d0000）
     from space 1024K，39%used[0x031d0000，0x03235338，0x032d0000）
     to space 1024K，0%used[0x032d0000，0x032d0000，0x033d0000）
     tenured generation total 10240K,used 4096K[0x033d0000，0x03dd0000，0x03dd0000）
     the space 10240K，40%used[0x033d0000，0x037d0010，0x037d0200，0x03dd0000）
     compacting perm gen total 12288K,used 2114K[0x03dd0000，0x049d0000，0x07dd0000）
     the space 12288K，17%used[0x03dd0000，0x03fe0998，0x03fe0a00，0x049d0000）
     No shared spaces configured.
     */
    
}
