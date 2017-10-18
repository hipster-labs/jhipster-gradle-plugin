package io.github.jhipster.gradle.plugins.base.task;

import groovy.lang.Closure;
import org.gradle.api.Task;
import org.gradle.jvm.tasks.Jar;

/**
 * Special task to generate a valid manifest for bootRun task. Must only be applied on windows environments.
 *
 * It replaces the custom written task:
 *
 *  `task pathingJar(type: Jar) {
        dependsOn configurations.runtime
        appendix = 'pathing'

        doFirst {
            manifest {
                attributes 'Class-Path': configurations.runtime.files.collect {
                    it.toURL().toString().replaceFirst(/file:\/+/, '/').replaceAll(' ', '%20')
                }.join(' ')
            }
        }
     }
 */
public class PathingJarTask extends Jar {

    public static final String TASK_NAME = "pathingJar";
    public static final String DESCRIPTION = "";

    @Override
    public String getAppendix() {
        return "pathing";
    }

    @Override
    public Task doFirst(Closure action) {

        return super.doFirst(action);
    }
}
