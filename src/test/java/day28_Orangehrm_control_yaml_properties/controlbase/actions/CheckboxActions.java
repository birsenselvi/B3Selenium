package day28_Orangehrm_control_yaml_properties.controlbase.actions;

import day28_Orangehrm_control_yaml_properties.controlbase.controls.CheckboxControl;


public class CheckboxActions {

    public static void checkbox1(String name){
        CheckboxControl
                .check(name);

    }
    public static void  controll(String name)
    {
            CheckboxControl
                    .control(name);


    }
}
