package com.sdet.auto.TestHelper;

public class TestAssert {

    private boolean pass;

    public TestAssert(){
        this.pass = true;
    }

    public boolean getPass() {
        return pass;
    }

    public void setPass(boolean pass) {

        if(this.pass == true)
        {
            this.pass = pass;
        }
    }
}
