package io.github.jhipster.gradle.plugins.base;

import io.github.jhipster.gradle.plugins.base.task.PathingJarTask;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.plugins.HelpTasksPlugin;
import org.gradle.api.plugins.JavaPlugin;
import org.gradle.internal.os.OperatingSystem;


/**
 * A plugin to apply all common tasks, plugins and dependencies which are common for all jhipster generated applications.
 */
public class JhipsterBasePlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {

        applyBasePlugins(project);

        createPathingJarTaskIfRequired(project);

    }

    /**
     * Creates a custom pathing jar task to create a correct manifest for boot run task.
     * It is only required when using windows.
     *
     * @param project
     */
    private void createPathingJarTaskIfRequired(Project project) {

        if (OperatingSystem.current().isWindows()) {

            PathingJarTask pathingJarTask = project.getTasks().create(PathingJarTask.TASK_NAME, PathingJarTask.class);
            pathingJarTask.setGroup(HelpTasksPlugin.HELP_GROUP);
            pathingJarTask.setDescription(PathingJarTask.DESCRIPTION);

        }

    }

    private void applyBasePlugins(Project project) {

        project.getPlugins().apply(JavaPlugin.class);
    }
}
