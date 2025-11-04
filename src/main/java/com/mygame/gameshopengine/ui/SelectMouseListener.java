/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mygame.gameshopengine.ui;

/**
 *
 * @author alyndenjayevans
 */
//package com.mygame.gameshopengine.ui;

//import static com.mygame.gameshopengine.ui.Selector.geometryScaler;
//import static com.mygame.gameshopengine.ui.Selector.moveNode;
//import static com.mygame.gameshopengine.ui.Selector.mover;
//import static com.mygame.gameshopengine.ui.Selector.selected;
//import static com.mygame.gameshopengine.ui.Selector.delta;
import com.jme3.collision.CollisionResults;
import com.jme3.input.KeyInput;
import com.jme3.input.RawInputListener;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.TouchListener;
import com.jme3.input.event.JoyAxisEvent;
import com.jme3.input.event.JoyButtonEvent;
import com.jme3.input.event.KeyInputEvent;
import com.jme3.input.event.MouseButtonEvent;
import com.jme3.input.event.MouseMotionEvent;
import com.jme3.input.event.TouchEvent;
import static com.jme3.input.event.TouchEvent.Type.DOWN;
import static com.jme3.input.event.TouchEvent.Type.MOVE;
import static com.jme3.input.event.TouchEvent.Type.SCROLL;
import static com.jme3.input.event.TouchEvent.Type.TAP;
import static com.jme3.input.event.TouchEvent.Type.UP;
import com.jme3.math.Ray;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;

import com.gameshopcorp.heroes.app.App;

public class SelectMouseListener implements RawInputListener {//implements ActionListener, AnalogListener {

    //public int lastEventPointer = -1;

    public static int lastEventPointer = -1;

    public SelectMouseListener(){
      //  this.lastEventPointer = lastEventPointer;
    }
    
  
    
    public boolean clickLeft = false;
    public boolean canMove = false;
    public float elapsedTPF = 0f;

    public String clickState = "CLICK";// CLICK MOVE RELEASE
    public String moveState = "MoveRight";// MoveRight MoveLeft
    /*
    @Override
    public void onAction(String name, boolean keyPressed, float tpf) {
       
        if (name.equals("ClickRight") && keyPressed){ //TAP
        
            // if (!clickLeft){
             
                 clickOnSomething();
                 
             
        }
        
        if (name.equals("MoveSelector") && keyPressed){
        System.out.println("MoveSelector");
            canMove = true;
        }
        
        if (name.equals("Deselect") && keyPressed){
        
            System.out.println("Deselect");
            release();
        }
      
    }

    public boolean moved = false;
    
    @Override
    public void onAnalog(String name, float value, float tpf) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       //System.out.println(canMove);
             if (canMove){
             
                 moveSelector(name);
             }
        
    }
    */
   
    /*
    public void release(){
    Vector2f release2d = App.app.getInputManager().getCursorPosition();
                App.screenContainer.release(release2d);
//                    for (SuperMesh s: AppSuperMesh.superMeshes.values()){
//                        s.update();
//                    }
//                    if (!movers.isEmpty()) {
                if (App.screenContainer.selectedScreen.equals("uiScreen")) {

                    if (geometryScaler.selected) {
                       // if (canMove){
                       App.selector.moveAllSelectedPointsRelativeToCenter();
                      //  }                       
// App.selector.moveAllSelectedPoints();
                        geometryScaler.deselect();
                        App.selector.makeScaler();
                    }
                    if (!selected.isEmpty()) {
                       // if (canMove){
                        App.selector.moveAllSelectedPoints();
                      //  }
                      //  App.selector.removeFromMoveNode();
//                        App.selector.moveAllSelectedPoints();
                        if (selected.size() > 1) {
                            App.selector.makeScaler();
                        }
                    }
                    //moved = false;
                   // lastMoveNode.setLocalTranslation(moveNode.getWorldTranslation());
                } else if (App.screenContainer.selectedScreen.equals("uiScreenATMS")) {

                }
    }
    
    public void clickOnSomething(){
      CollisionResults results = new CollisionResults();
            // Convert screen click to 3d position
            Vector2f click2d = App.app.getInputManager().getCursorPosition();
            App.screenContainer.click(click2d);

            Vector3f click3d = App.app.getCamera().getWorldCoordinates(new Vector2f(click2d.x, click2d.y), 0f).clone();
            Vector3f dir = App.app.getCamera().getWorldCoordinates(new Vector2f(click2d.x, click2d.y), 1f).subtractLocal(click3d).normalizeLocal();
            // Aim the ray from the clicked spot forwards.
            Ray ray = new Ray(click3d, dir);
            // Collect intersections between ray and all nodes in results list.
            App.app.getRootNode().collideWith(ray, results);
            // (Print the results so we see what is going on:)
            for (int i = 0; i < results.size(); i++) {
                // (For each "hit", we know distance, impact point, geometry.)
                float dist = results.getCollision(i).getDistance();
                Vector3f pt = results.getCollision(i).getContactPoint();
                String target = results.getCollision(i).getGeometry().getName();
//                        if (results.getCollision(i).getGeometry().getName().contains("Box")){
//                            selected.add(results.getCollision(i).getGeometry())
//                        }
                //      System.out.println("Selection #" + i + ": " + target + " at " + pt + ", " + dist + " WU away.");
            }

            if (App.screenContainer.selectedScreen.equals("uiScreen")) {

               // canMove = true;
                // Use the results -- we rotate the selected geometry.
                if (results.size() > 0) {
                   // canMove = true;
                    // The closest result is the target that the player picked:
                    Target target = null;

                    for (int i = 0; i < results.size(); i++) {
                        String targetName = results.getCollision(i).getGeometry().getName();

                        if (!targetName.contains("Box") && !targetName.contains("Move") && !targetName.contains("Scale")) {
                          //  canMove = false;
                            continue;
                        }
                        if (targetName.contains("Box")) {
                            target = (GeometrySelector) results.getCollision(i).getGeometry();
                            //canMove = true;
                        }
                        if (targetName.contains("Move")) {
                            target = (GeometryMover) results.getCollision(i).getGeometry();
                            //canMove = true;
                        }
                        if (targetName.contains("Scale")) {
                            target = (GeometryScaler) results.getCollision(i).getGeometry();
                            //canMove = true;
                        }
                        break;
                    }
                    if (target != null) {
                        //forresults.getClosestCollision().getGeometry();
                        // Here comes the action:
                        if (target.getName().contains("Box")) {

                            target.select();
                            if (target instanceof GeometrySelector) {
                                App.selector.addSelectors((GeometrySelector) target);
                            }

                            //if (geometryMovers.isEmpty()){
                            App.selector.clearMovers();
                            App.selector.populateMovers();
//                                if (selected.size() > 1) {
//                                    App.selector.makeScaler();
//                                }
                            // App.selector.addToSelectedNode();

                        }

                        if (target.getName().contains("Move")) {

                            geometryScaler.deselect();
                            App.selector.resetMovers();
                            target.select();
                            if (target instanceof GeometryMover) {
                                mover = (GeometryMover) target;
                            }

                        }
                        if (target.getName().contains("Scale")) {
                            App.selector.resetMovers();
                            mover.deselect();
                            target.select();

                        }
                    }
                }    
            }
    }
    
    public void moveSelector(String name){
    
              
             
        Vector2f scroll2d = App.app.getInputManager().getCursorPosition();
        if (App.screenContainer.scroll(scroll2d).equals("")) {

            if (App.screenContainer.selectedScreen.equals("uiScreen")) {

                if (geometryScaler.selected) {

                   // moved = true;
                    
                    if (name.equals("MoveRight")) {
                        geometryScaler.move(0.01f, -0.01f, 0.01f);
                    }
                    if (name.equals("MoveLeft")) {
                        geometryScaler.move(-0.01f, 0.01f, -0.01f);

                    }
                }
                if (mover.selected) {
//                    moved = true;
                    if (mover.getName().contains("Up")) {
                        if (name.equals("MoveRight")) {
                            delta = delta.add(0, 0.01f , 0);
                            moveNode.move(0, 0.01f  , 0);
                        }
                        if (name.equals("MoveLeft")) {
                            delta = delta.add(0, -0.01f  , 0);
                            moveNode.move(0, -0.01f , 0);
                        }
                        System.out.println("X: " + scroll2d.x);

                    }
                    if (mover.getName().contains("Down")) {
                        if (name.equals("MoveRight")) {
                            delta = delta.add(0, 0.01f, 0);
                            moveNode.move(0, 0.01f, 0);
                        }
                        if (name.equals("MoveLeft")) {
                            delta = delta.add(0, -0.01f, 0);
                            moveNode.move(0, -0.01f, 0);
                        }
                    }
                    if (mover.getName().contains("Left")) {
                        if (name.equals("MoveRight")) {
                            delta = delta.add(0.01f, 0.0f, 0);
                            moveNode.move(0.01f, 0, 0);
                        }
                        if (name.equals("MoveLeft")) {
                            delta = delta.add(-0.01f, 0f, 0);
                            moveNode.move(-0.01f, 0, 0);
                        }
                    }
                    if (mover.getName().contains("Right")) {
                        if (name.equals("MoveRight")) {
                            delta = delta.add(0.01f, 0, 0);
                            moveNode.move(0.01f, 0, 0);
                        }
                        if (name.equals("MoveLeft")) {
                            delta = delta.add(-0.01f, 0f, 0);
                            moveNode.move(-0.01f, 0, 0);
                        }
                    }
                    if (mover.getName().contains("Front")) {
                        if (name.equals("MoveRight")) {
                            delta = delta.add(0, 0f, 0.01f);
                            moveNode.move(0, 0, 0.01f);
                        }
                        if (name.equals("MoveLeft")) {
                            delta = delta.add(0, 0.0f, -0.01f);
                            moveNode.move(0, 0, -0.01f);
                        }
                    }
                    if (mover.getName().contains("Back")) {
                        if (name.equals("MoveRight")) {
                            delta = delta.add(0, 0.0f, 0.01f);
                            moveNode.move(0, 0, 0.01f);
                        }
                        if (name.equals("MoveLeft")) {
                            delta = delta.add(0, 0.0f, -0.01f);
                            moveNode.move(0, 0, -0.01f);
                        }
                    }
                }
            } else if (App.screenContainer.selectedScreen.equals("uiScreenATMS")) {

            }
        //}
        }
    }

    public boolean selected(){
    
        if (mover.selected || geometryScaler.selected){
        
            return true;
        }
        return false;
    }
    */
    @Override
    public void beginInput() {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void endInput() {
     //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void onJoyAxisEvent(JoyAxisEvent jae) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void onJoyButtonEvent(JoyButtonEvent jbe) {
     //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*
    @Override
    public void onMouseMotionEvent(MouseMotionEvent mme) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
      if (mme.getDX() > 0){
          moveState = "MoveLeft";
      } else if (mme.getDX() < 0){
      
          moveState = "MoveRight";
      }
      
       if (clickState.equals("MOVE")){
            
                moveSelector(moveState);
        }
    }
    

    @Override
    public void onMouseButtonEvent(MouseButtonEvent mbe) {
      
        if (mbe.getButtonIndex() == 0 && mbe.isPressed()){
        
            if (clickState.equals("CLICK")){
            clickOnSomething();
            
            if (selected()){
             clickState = "MOVE";
            }
            
            } else if (clickState.equals("MOVE")){
            
                //if (selected()){
                
                    clickState = "RELEASE";
                //}
            } else if (clickState.equals("RELEASE")){
            
                release();
                clickState = "CLICK";
            }
            
//            if (App.screenContainer.selectedScreen.equals("uiScreenATMS")){
//            
//                clickState = "CLICK";
//            }
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    */

    @Override
    public void onKeyEvent(KeyInputEvent kie) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
//       if (kie.getKeyChar() == 'g' && kie.isPressed()){
//       
//           moveSelector("MoveRight");
//       }
//       
//       if (kie.getKeyChar() == 'q' && kie.isPressed()){
//       
//           release();
//       }
//System.out.println("KeyPressed");

         if (kie.getKeyChar() == 'w' && kie.isPressed()){
         
             Vector3f towards = new Vector3f(App.target.getWorldTranslation().subtract(App.camNode.getWorldTranslation())).mult(0.01f);
             
             App.target.move(towards);
         }
         
         if (kie.getKeyChar() == 's' && kie.isPressed()){
         
             Vector3f towards = new Vector3f(App.target.getWorldTranslation().subtract(App.camNode.getWorldTranslation())).mult(-0.01f);
             
             App.target.move(towards);
         }
         
         if (kie.getKeyChar() == 'a' && kie.isPressed()){
         
             //Vector3f towards = new Vector3f(App.target.getWorldTranslation().subtract(App.camNode.getWorldTranslation())).mult(-0.01f);
                  App.target.move(App.xAxisRightTarget.getWorldTranslation().subtract(App.target.getWorldTranslation()).divide(4));
             
             //App.target.rotate(0,-1/180f,0);
         }
         
         if (kie.getKeyChar() == 'd' && kie.isPressed()){
         
//             Vector3f towards = new Vector3f(App.target.getWorldTranslation().subtract(App.camNode.getWorldTranslation())).mult(-0.01f);
//             
//             App.target.move(towards);
             //App.target.rotate(0,1/180f,0);
                App.target.move(App.xAxisLeftTarget.getWorldTranslation().subtract(App.target.getWorldTranslation()).divide(4));


         }
         
         if (kie.getKeyChar() == 'q' && kie.isPressed()){
         
//             Vector3f towards = new Vector3f(App.target.getWorldTranslation().subtract(App.camNode.getWorldTranslation())).mult(-0.01f);
//             
//             App.target.move(towards);
             //App.target.rotate(0,1/180f,0);
                App.target.move(App.yAxisUpTarget.getWorldTranslation().subtract(App.target.getWorldTranslation()).divide(4));


         }
         
         if (kie.getKeyChar() == 'z' && kie.isPressed()){
         
//             Vector3f towards = new Vector3f(App.target.getWorldTranslation().subtract(App.camNode.getWorldTranslation())).mult(-0.01f);
//             
//             App.target.move(towards);
             //App.target.rotate(0,1/180f,0);
                App.target.move(App.yAxisDownTarget.getWorldTranslation().subtract(App.target.getWorldTranslation()).divide(4));


         }
         
         if (kie.getKeyCode() ==  KeyInput.KEY_RIGHT && kie.isRepeating()){
         
//             Vector3f towards = new Vector3f(App.target.getWorldTranslation().subtract(App.camNode.getWorldTranslation())).mult(-0.01f);
//             
//             App.target.move(towards);
             App.target.rotate(0,4/180f,0);
               // App.target.move(App.xAxisLeftTarget.getWorldTranslation().subtract(App.target.getWorldTranslation()).divide(4));


         }
         
           if (kie.getKeyCode() ==  KeyInput.KEY_LEFT && kie.isRepeating()){
         
//             Vector3f towards = new Vector3f(App.target.getWorldTranslation().subtract(App.camNode.getWorldTranslation())).mult(-0.01f);
//             
//             App.target.move(towards);
             App.target.rotate(0,-4/180f,0);
               // App.target.move(App.xAxisLeftTarget.getWorldTranslation().subtract(App.target.getWorldTranslation()).divide(4));


         }
           
            if (kie.getKeyCode() ==  KeyInput.KEY_UP && kie.isRepeating()){
         
//             Vector3f towards = new Vector3f(App.target.getWorldTranslation().subtract(App.camNode.getWorldTranslation())).mult(-0.01f);
//             
//             App.target.move(towards);
             App.target.rotate(4/180f,0,0);
               // App.target.move(App.xAxisLeftTarget.getWorldTranslation().subtract(App.target.getWorldTranslation()).divide(4));


         }
            
             if (kie.getKeyCode() ==  KeyInput.KEY_DOWN && kie.isRepeating()){
         
//             Vector3f towards = new Vector3f(App.target.getWorldTranslation().subtract(App.camNode.getWorldTranslation())).mult(-0.01f);
//             
//             App.target.move(towards);
             App.target.rotate(-4/180f,0,0);
               // App.target.move(App.xAxisLeftTarget.getWorldTranslation().subtract(App.target.getWorldTranslation()).divide(4));


         }
         
         
    }

    @Override
    public void onTouchEvent(TouchEvent te) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void onMouseMotionEvent(MouseMotionEvent mme) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void onMouseButtonEvent(MouseButtonEvent mbe) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
