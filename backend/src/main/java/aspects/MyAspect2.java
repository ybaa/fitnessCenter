/*
 * LoggingWithAspectJ - Logging with AspectJ
 * Copyright (C) 2007 Christian Schenk
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA
 */
package aspects;

import com.sun.jmx.snmp.Timestamp;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

@Aspect
@Component
public class MyAspect2 {

    Map<String, Integer> counter = new HashMap<String, Integer>();


    private static <K, V> V getOrDefault(Map<K,V> map, K key, V defaultValue) {
        return map.containsKey(key) ? map.get(key) : defaultValue;
    }


    @Pointcut("execution(* com.addictionFitnessCenter.Timetable.TimetableController.*(..))")
    public void showLog() {
    }


    @Around("showLog()")
    public Object doThing(final ProceedingJoinPoint thisJoinPoint) throws Throwable {
        Timestamp timestamp = new Timestamp();



        final String joinPointName = thisJoinPoint.getThis().getClass().getSimpleName() + "." + thisJoinPoint.getSignature().getName() + "()";
        System.out.println("-----------------------  ENTERING  ------------------------------");
        System.out.println("METHOD: " + joinPointName);
        System.out.println("called at " + timestamp);

        int i = getOrDefault(counter, joinPointName, 0);
        i++;
        counter.put(joinPointName, i );

        Object retVal = thisJoinPoint.proceed();

        System.out.println("Method has been called for the " + counter.get(joinPointName) + " time");
        System.out.println("-----------------------  LEAVING  ------------------------------");
        return retVal;
    }
}