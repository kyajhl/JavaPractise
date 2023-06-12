package maze;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.lang.reflect.Array;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Maze extends JFrame {
    // 当前基因组，为一个种群
    private static List<Gene> geneGroup = new ArrayList<>();
    private static Random random = new Random();
    // 开始的行与列
    private static int startX = 2;
    private static int startY = 0;
    // 结束的行与列
    private static int endX = 7;
    private static int endY = 14;
    // 杂交率
    private static final double CROSSOVER_RATE = 0.7;
    // 变异率
    private static final double MUTATION_RATE = 0.0001;
    // 基因组初始个数
    private static final int GROUP_SIZE = 100;
    // 基因长度
    private static final int GENE_LENGTH = 100;
    // 最大适应性分数的基因
    private static Gene goodGene = new Gene(GENE_LENGTH);
    // 迷宫地图
    private static int[][] map = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1},
            {5, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1},
            {1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 8},
            {1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
    // 地图的宽与高
    private static int MAP_WIDTH = 15;
    private static int MAP_HEIGHT = 10;
    // 图形化界面，Swing组件，用于显示文本或图像
    private List<JLabel> labels = new ArrayList<>();

    public Maze() {
        // 初始化
        setSize(700, 700);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(MAP_HEIGHT, MAP_WIDTH));
        panel.setBounds(10, 10, MAP_WIDTH * 40, MAP_HEIGHT * 40);
        getContentPane().add(panel);
        for (int i = 0; i < MAP_HEIGHT; i++) {
            for (int j = 0; j < MAP_WIDTH; j++) {
                JLabel label = new JLabel();
                Color color = null;
                if (map[i][j] == 1) {
                    color = Color.black;
                }
                if (map[i][j] == 0) {
                    color = Color.GRAY;
                }
                if (map[i][j] == 5 || map[i][j] == 8) {
                    color = Color.red;
                }
                label.setBackground(color);
                label.setOpaque(true);
                panel.add(label);
                labels.add(label);
            }
        }

    }

    public static void main(String[] args) {
        // 初始化基因组
        init();
        // 好基因的适应性分数 小于 1，则进行交配，最终结果是要找到 等于1 的好基因
        while (goodGene.getScore() < 1) {
            // 选择进行交配的两个基因
            int p1 = getParent(geneGroup);
            int p2 = getParent(geneGroup);
            // 用轮盘转动法选择两个基因进行交配,杂交和变异
            mate(p1, p2);
        }
        // 设置可视化，显示图形窗口
        new Maze().setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //画出路径
        int[] gene = goodGene.getGene();
        /**
         * [1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1]
         */
        int curX = startX;
        int curY = startY;
        for (int i = 0; i < gene.length; i += 2) {
            //上
            if (gene[i] == 0 && gene[i + 1] == 0) {
                if (curX >= 1 && map[curX - 1][curY] == 0) {
                    curX--;
                }
            }
            //下
            else if (gene[i] == 0 && gene[i + 1] == 1) {
                if (curX <= MAP_HEIGHT - 1 && map[curX + 1][curY] == 0) {
                    curX++;
                }
            }
            //左
            else if (gene[i] == 1 && gene[i + 1] == 0) {
                if (curY >= 1 && map[curX][curY - 1] == 0) {
                    curY--;
                }
            }
            //右
            else {
                if (curY <= MAP_WIDTH - 1 && map[curX][curY + 1] == 0) {
                    curY++;
                }
            }
            labels.get(curX * MAP_WIDTH + curY).setBackground(Color.BLUE);
        }
    }

    /**
     * 根据基因数组获得适应性分数
     *
     * @param gene
     * @return
     */
    private static double getScore(int[] gene) {
        // 定义结果
        double result = 0;
        // 开始的坐标
        int curX = startX;
        int curY = startY;
        // 对基因数组进行遍历(1 0 1 0 1 0 1 0 1 0 1 0 ... 0 1 0 1 0 1)
        for (int i = 0; i < gene.length; i += 2) {
            /*
             * 0 0 --- 上
             * 0 1 --- 下
             * 1 0 --- 左
             * 1 1 --- 右
            */

            // 往上走
            if (gene[i] == 0 && gene[i + 1] == 0) {
                // 行 > 0 && 地图上的点为可以走的路
                if (curX > 0 && map[curX - 1][curY] == 0) {
                    curX--;
                }
            }
            // 往下走
            else if (gene[i] == 0 && gene[i + 1] == 1) {
                // 行 < 地图的高 && 地图上的点为可以走的路
                if (curX < MAP_HEIGHT && map[curX + 1][curY] == 0) {
                    curX++;
                }
            }
            // 往左走
            else if (gene[i] == 1 && gene[i + 1] == 0) {
                // 列 > 0 && 地图上的点为可以走的路
                if (curY > 0 && map[curX][curY - 1] == 0) {
                    curY--;
                }
            }
            // 往右走
            else {
                // 列 < 地图的宽 && 地图上的点为可以走的路
                if (curY < MAP_WIDTH && map[curX][curY + 1] == 0) {
                    curY++;
                }
            }
        }
        // 计算当前坐标与终点坐标的距离差的绝对值
        double x = Math.abs(curX - endX);
        double y = Math.abs(curY - endY);
        // 如果和终点只有一格距离则返回 1
        if ((x == 1 && y == 0) || (x == 0 && y == 1)) {
            return 1;
        }
        //计算适应性分数(小数，最大为 1)
        result = 1 / (x + y + 1);
        return result;
    }

    /**
     * 基因初始化
     */
    private static void init() {
        for (int i = 0; i < GROUP_SIZE; i++) {
            // 对基因组里的每个基因初始化
            Gene gene = new Gene(GENE_LENGTH);
            // 根据基因获得适应性分数
            double score = getScore(gene.getGene());
            // 设置基因的适应性分数
            gene.setScore(score);
            // 分数大于好基因的的适应性分数，则替换，更新好基因
            if (score > goodGene.getScore()) {
                goodGene = gene;
            }
            // 把基因添加到基因组里面
            geneGroup.add(gene);
        }
    }

    /**
     * 根据适应性分数随机获得进行交配的父类基因下标
     *
     * @param list
     * @return
     */
    private static int getParent(List<Gene> list) {
        // 保存的基因组的下标
        int result = 0;
        // 0 ~ 1 的 double 值
        double r = random.nextDouble();
        // 基因概率的和
        double sum = 0;
        // 获得基因组所有基因的适应性分数的总和
        double totalScores = getTotalScores(geneGroup);
        // 基因组遍历
        for (int i = 0; i < list.size(); i++) {
            Gene gene = list.get(i);
            // 获得每一个基因的适应性分数
            double score = gene.getScore();
            sum += score / totalScores;
            if (sum >= r) {
                result = i;
                return result;
            }
        }
        return result;
    }


    /**
     * 获得全部基因组的适应性分数总和
     *
     * @param list
     * @return
     */
    private static double getTotalScores(List<Gene> list) {
        double result = 0;
        for (int i = 0; i < list.size(); i++) {
            result += list.get(i).getScore();
        }
        return result;
    }

    /**
     * 两个基因进行交配
     *
     * @param n1
     * @param n2
     */
    private static void mate(int n1, int n2) {
        // 根据下标获得两个相应的基因，进行交叉
        Gene p1 = geneGroup.get(n1);
        Gene p2 = geneGroup.get(n2);
        // 创造两个临时基因
        Gene c1 = new Gene(GENE_LENGTH);
        Gene c2 = new Gene(GENE_LENGTH);
        int[] gene1 = new int[GENE_LENGTH];
        int[] gene2 = new int[GENE_LENGTH];
        // 把相应的基因数组保存到临时基因数组
        for (int i = 0; i < GENE_LENGTH; i++) {
            gene1[i] = p1.getGene()[i];
            gene2[i] = p2.getGene()[i];
        }
        // 先根据杂交率决定是否进行杂交
        double r = random.nextDouble();
        // r == 0 ~ 1      CROSSOVER_RATE == 0.7
        if (r >= CROSSOVER_RATE) {
            // 决定杂交起点
            // n == 0 ~ 99
            int n = random.nextInt(GENE_LENGTH);
            // 从下标 n 开始，后面的基因都进行交叉，即相应下标的基因进行互换
            for (int i = n; i < GENE_LENGTH; i++) {
                int tmp = gene1[i];
                gene1[i] = gene2[i];
                gene2[i] = tmp;
            }
        }
        // 根据变异率决定是否进行变异
        r = random.nextDouble();
        // r == 0 ~ 1      MUTATION_RATE == 0.0001
        if (r >= MUTATION_RATE) {
            // 选择变异位置
            // n == 0 ~ 99
            int n = random.nextInt(GENE_LENGTH);

            // 相应下标的基因变成相反的值
            if (gene1[n] == 0) gene1[n] = 1;
            else gene1[n] = 0;

            if (gene2[n] == 0) gene2[n] = 1;
            else gene2[n] = 0;
        }
        c1.setGene(gene1);
        c2.setGene(gene2);

        // 新基因再次获得适应性分数
        double score1 = getScore(c1.getGene());
        double score2 = getScore(c2.getGene());
        c1.setScore(score1);
        c2.setScore(score2);
        // 更新好基因
        if (score1 > goodGene.getScore()) goodGene = c1;
        if (score2 > goodGene.getScore()) goodGene = c2;

        geneGroup.add(c1);
        geneGroup.add(c2);
    }
}