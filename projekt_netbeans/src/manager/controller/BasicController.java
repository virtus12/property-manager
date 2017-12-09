/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.controller;

import manager.view.BasicFrame;

/**
 *
 * @author virtus
 */
public class BasicController implements Runnable{
    private BasicFrame basicFrame;
   
    
    public BasicFrame getFrameInstance(){
        return basicFrame;
    
    }
    @Override
    public void run() {
        basicFrame = new BasicFrame();
        basicFrame.setVisible(true);
    }
}
