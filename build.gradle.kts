plugins {
  kotlin("js")
  id("com.github.jakemarsden.git-hooks")
  id("org.jlleitschuh.gradle.ktlint")
  idea
}

idea {
  module {
    isDownloadJavadoc = true
    isDownloadSources = true
  }
}

gitHooks {
  setHooks(
    mapOf(
      "post-checkout" to "ktlintApplyToIdea",
      "pre-commit" to "ktlintFormat",
      "pre-push" to "check"
    )
  )
}

repositories {
  mavenLocal()
  mavenCentral()
  gradlePluginPortal()
}

kotlin {
  js {
    useCommonJs()
    binaries.executable()
    browser {
      commonWebpackConfig {
        cssSupport.enabled = true
        devServer = devServer?.copy(
          port = 3000,
          proxy = mapOf("/api/*" to "http://localhost:8080"),
          open = false
        )
      }
    }
  }
  sourceSets {
    main {
      languageSettings.apply {
        useExperimentalAnnotation("kotlinx.coroutines.ExperimentalCoroutinesApi")
        useExperimentalAnnotation("kotlin.time.ExperimentalTime")
      }
    }
  }
  dependencies {
    implementation("io.ktor:ktor-client-serialization:_")
    implementation("dev.fritz2:components:_")
  }
}
