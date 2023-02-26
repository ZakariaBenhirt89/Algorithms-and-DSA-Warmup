package org.algo.me;


import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo( name = "sayhi")
public class MojoClass  extends AbstractMojo{
    public void execute() throws MojoExecutionException
    {
        getLog().info( "Hello, world." );
    }
}
