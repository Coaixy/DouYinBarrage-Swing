package ren.lawliet.Java;

import javax.swing.*;
import java.net.UnknownHostException;

/**
 * @author Coaixy
 * @createTime 2024-06-01
 * @packageName ren.lawliet.Java
 */

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    /**{
     * 创建并显示GUI。出于线程安全的考虑，
     * 这个方法在事件调用线程中调用。
     */
    static JTextArea text = new JTextArea();
    private static void createAndShowGUI() {
        // 确保一个漂亮的外观风格
        JFrame.setDefaultLookAndFeelDecorated(true);

        // 创建及设置窗口
        JFrame frame = new JFrame("DouYinBarrage");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        text.setLineWrap(true);
        JScrollPane scrollpane = new JScrollPane(text);
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

//        frame.getContentPane().add(text);
        frame.getContentPane().add(scrollpane);

        // 显示窗口
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) throws UnknownHostException {
        var server = new WsServer(5100);
        server.start();
        server.setAreaObj(text);
        // 显示应用 GUI
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}