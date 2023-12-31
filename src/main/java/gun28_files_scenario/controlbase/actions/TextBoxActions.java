package gun28_files_scenario.controlbase.actions;

import gun28_files_scenario.controlbase.controls.TextBoxControl;

public class TextBoxActions {

    public static void sendKeys(String label, CharSequence...text){
        TextBoxControl
                .fromLabel(label)
                .sendKeys(text)
        ;
    }

    public static void select(String label, String option){
        TextBoxControl
                .fromLabel(label)
                .select(option)
        ;
    }
}
