if(System.getenv('TRAVIS_BRANCH')) {
    grails.project.repos.grailsCentral.username = System.getenv("GRAILS_CENTRAL_USERNAME")
    grails.project.repos.grailsCentral.password = System.getenv("GRAILS_CENTRAL_PASSWORD")    
}

grails.project.work.dir = 'target'
grails.project.docs.output.dir = 'docs/manual' // for gh-pages branch
grails.project.source.level = 1.7
grails.project.target.level = 1.7

grails.project.dependency.resolver='maven'
grails.project.dependency.resolution = {

	inherits 'global'
	log 'warn'

	repositories {
		grailsCentral()
		mavenLocal()
		mavenCentral()
	}

	dependencies {

		String jettyVersion = '9.0.7.v20131107'

        runtime ("org.eclipse.jetty.aggregate:jetty-all:$jettyVersion") {
            transitive = false
        }

		// needed for JSP compilation
		runtime 'org.eclipse.jdt.core.compiler:ecj:4.3.1'
	}

	plugins {
		build(':release:3.0.1', ':rest-client-builder:2.0.1') {
			export = false
		}
	}
}
