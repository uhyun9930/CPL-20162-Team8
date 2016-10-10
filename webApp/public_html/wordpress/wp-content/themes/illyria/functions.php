<?php

add_action( 'wp_enqueue_scripts', 'illyria_enqueue_styles' );

function illyria_enqueue_styles() {
    wp_enqueue_style( 'parent-style', get_template_directory_uri() . '/style.css' );
}

function illyria_custom_script_fix() {
   
	wp_enqueue_script('illyria_script_child',get_stylesheet_directory_uri().'/js/wrapall.js', array('jquery') );
	
}

add_action( 'wp_enqueue_scripts', 'illyria_custom_script_fix', 100 );

function illyria_inline_styles() {
	?>
	<style type="text/css">

		<?php if(is_front_page()): ?>
		.wrap-elements {
		  position: absolute !important;
		}
		<?php else: ?>
		.wrap-elements {
		 position: relative !important;
		}
		<?php endif; ?>
	</style>
	<?php
}

add_action("wp_print_scripts","illyria_inline_styles");

/**
 * Declare textdomain for this child theme.
 * Translations can be filed in the /languages/ directory.
 */
function illyria_theme_setup() {
    load_child_theme_textdomain( 'illyria', get_stylesheet_directory() . '/languages' );
}
add_action( 'after_setup_theme', 'illyria_theme_setup' );