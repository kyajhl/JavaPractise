package maze;

import java.util.Arrays;
import java.util.Random;

/**
 * @author KeFan
 * @date 2023/5/12
 * @time 20:46
 */

public class Gene {
    // 基因长度
    private int len;
    // 基因数组
    private int[] gene;
    // 适应性分数
    private double score;

    public Gene(int len) {
        this.len = len;
        this.gene = new int[len];
        Random random = new Random();
        // 随机生成一个基因序列
        for (int i = 0; i < len; i++) {
            // 0，1序列
            gene[i] = random.nextInt(2);
        }
        // 适应性分数设置为 0
        this.score = 0;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public int[] getGene() {
        return gene;
    }

    public void setGene(int[] gene) {
        this.gene = gene;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < gene.length; i += 2) {
            if (gene[i] == 0 && gene[i + 1] == 0) {
                sb.append("上");
            }
            //下
            else if (gene[i] == 0 && gene[i + 1] == 1) {
                sb.append("下");
            }
            //左
            else if (gene[i] == 1 && gene[i + 1] == 0) {
                sb.append("左");
            }
            //右
            else {
                sb.append("右");
            }
        }
        System.out.println(sb.toString());
    }
}
