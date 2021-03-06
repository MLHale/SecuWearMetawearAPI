/*
 * Copyright 2014-2015 MbientLab Inc. All rights reserved.
 *
 * IMPORTANT: Your use of this Software is limited to those specific rights granted under the terms of a software
 * license agreement between the user who downloaded the software, his/her employer (which must be your
 * employer) and MbientLab Inc, (the "License").  You may not use this Software unless you agree to abide by the
 * terms of the License which can be found at www.mbientlab.com/terms.  The License limits your use, and you
 * acknowledge, that the Software may be modified, copied, and distributed when used in conjunction with an
 * MbientLab Inc, product.  Other than for the foregoing purpose, you may not use, reproduce, copy, prepare
 * derivative works of, modify, distribute, perform, display or sell this Software and/or its documentation for any
 * purpose.
 *
 * YOU FURTHER ACKNOWLEDGE AND AGREE THAT THE SOFTWARE AND DOCUMENTATION ARE PROVIDED "AS IS" WITHOUT WARRANTY
 * OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING WITHOUT LIMITATION, ANY WARRANTY OF MERCHANTABILITY, TITLE,
 * NON-INFRINGEMENT AND FITNESS FOR A PARTICULAR PURPOSE. IN NO EVENT SHALL MBIENTLAB OR ITS LICENSORS BE LIABLE OR
 * OBLIGATED UNDER CONTRACT, NEGLIGENCE, STRICT LIABILITY, CONTRIBUTION, BREACH OF WARRANTY, OR OTHER LEGAL EQUITABLE
 * THEORY ANY DIRECT OR INDIRECT DAMAGES OR EXPENSES INCLUDING BUT NOT LIMITED TO ANY INCIDENTAL, SPECIAL, INDIRECT,
 * PUNITIVE OR CONSEQUENTIAL DAMAGES, LOST PROFITS OR LOST DATA, COST OF PROCUREMENT OF SUBSTITUTE GOODS, TECHNOLOGY,
 * SERVICES, OR ANY CLAIMS BY THIRD PARTIES (INCLUDING BUT NOT LIMITED TO ANY DEFENSE THEREOF), OR OTHER SIMILAR COSTS.
 *
 * Should you have any questions regarding your right to use this Software, contact MbientLab via email:
 * hello@mbientlab.com.
 */

package com.mbientlab.metawear.module;

import com.mbientlab.metawear.DataSignal;
import com.mbientlab.metawear.MetaWearBoard;

/**
 * Generic class providing high level access to the temperature sensor.  If you know you are on firmware
 * v1.0.4 or higher, use the multi channel temperature class instead.  If you are on firmware v1.0.3 or
 * earlier, use the single channel temperature class.
 * @author Eric Tsai
 * @see MultiChannelTemperature
 * @see SingleChannelTemperature
 */
public interface Temperature extends MetaWearBoard.Module {
    /**
     * Generic selector for temperature data
     * @author Eric Tsai
     */
    interface SourceSelector {
        /**
         * Handle data from the temperature sensor
         * @return Object representing temperature data
         */
        DataSignal fromSensor();
        /**
         * Handle data from the temperature sensor.  This version of the function pairs with the
         * {@link #readTemperature(boolean)} variant
         * @param silent    Same value as the silent parameter for calling {@link #readTemperature(boolean)}
         * @return Object representing temperature data
         */
        DataSignal fromSensor(boolean silent);
    }

    /**
     * Reads value from a temperature sensor
     */
    void readTemperature();
    /**
     * Reads value from a temperature sensor
     * @param silent    True if read should be silent
     */
    void readTemperature(boolean silent);

    /**
     * Initiates the creation of a route for temperature data
     * @return Selection of available data sources
     */
    SourceSelector routeData();
}
