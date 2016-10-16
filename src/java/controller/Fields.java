/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Intermediate;
import beans.MatricInformation;


public class Fields {
    //BEANS OBJECTS
    private static Intermediate intermediate;
    private static MatricInformation matricInformation;

    /**
     * @return the intermediate
     */
    public static Intermediate getIntermediate() {
        return intermediate;
    }

    /**
     * @param aIntermediate the intermediate to set
     */
    public static void setIntermediate(Intermediate aIntermediate) {
        intermediate = aIntermediate;
    }

    /**
     * @return the matricInformation
     */
    public static MatricInformation getMatricInformation() {
        return matricInformation;
    }

    /**
     * @param aMatricInformation the matricInformation to set
     */
    public static void setMatricInformation(MatricInformation aMatricInformation) {
        matricInformation = aMatricInformation;
    }
}
