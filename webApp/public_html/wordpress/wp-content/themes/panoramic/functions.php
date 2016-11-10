<?php
/**
 * panoramic functions and definitions
 *
 * @package panoramic
 */
define( 'PANORAMIC_THEME_VERSION' , '1.0.18' );

if ( ! function_exists( 'panoramic_theme_setup' ) ) :
/**
 * Sets up theme defaults and registers support for various WordPress features.
 *
 * Note that this function is hooked into the after_setup_theme hook, which
 * runs before the init hook. The init hook is too late for some features, such
 * as indicating support for post thumbnails.
 */
function panoramic_theme_setup() {
	
	/**
	 * Set the content width based on the theme's design and stylesheet.
	 */
	global $content_width;
	if ( ! isset( $content_width ) ) {
		$content_width = 640; /* pixels */
	}
	
	$font_url = str_replace( ',', '%2C', '//fonts.googleapis.com/css?family=Lato:300,300italic,400,400italic,600,600italic,700,700italic' );
	add_editor_style( $font_url );
	
	$font_url = str_replace( ',', '%2C', '//fonts.googleapis.com/css?family=Raleway:500,600,700,100,800,400,300' );
	add_editor_style( $font_url );
	
	add_editor_style('editor-style.css');

	set_theme_mod( 'otb_panoramic_dot_org', true );
	
	/*
	 * Make theme available for translation.
	 * Translations can be filed in the /languages/ directory.
	 * If you're building a theme based on panoramic, use a find and replace
	 * to change 'panoramic' to the name of your theme in all the template files
	 */
	load_theme_textdomain( 'panoramic', get_template_directory() . '/languages' );

	// Add default posts and comments RSS feed links to head.
	add_theme_support( 'automatic-feed-links' );
	
	/*
	 * Enable support for Post Thumbnails on posts and pages.
	 *
	 * @link http://codex.wordpress.org/Function_Reference/add_theme_support#Post_Thumbnails
	 */
	add_theme_support( 'post-thumbnails' );
	add_image_size( 'panoramic_blog_img_side', 352, 230, true );

	// This theme uses wp_nav_menu() in one location.
	register_nav_menus( array(
		'primary' => __( 'Primary Menu', 'panoramic' ),
        'footer' => __( 'Footer Menu', 'panoramic' )
	) );

	/*
	 * Switch default core markup for search form, comment form, and comments
	 * to output valid HTML5.
	 */
	add_theme_support( 'html5', array(
		'search-form', 'comment-form', 'comment-list', 'gallery', 'caption',
	) );

	/*
	 * Enable support for Post Formats.
	 * See http://codex.wordpress.org/Post_Formats
	 */
	add_theme_support( 'post-formats', array(
		'aside', 'image', 'video', 'quote', 'link',
	) );

	/*
	 * Setup Custom Logo Support for theme
	 * Supported from WordPress version 4.5 onwards
	 * More Info: https://make.wordpress.org/core/2016/03/10/custom-logo/
	 */
	if ( function_exists( 'has_custom_logo' ) ) {
		add_theme_support( 'custom-logo' );
	}
	
	// The custom header is used if no slider is enabled
	add_theme_support( 'custom-header', array(
        'default-image' => get_template_directory_uri() . '/library/images/headers/default.jpg',
		'width'         => 1500,
		'height'        => 445,
		'flex-width'    => true,
		'flex-height'   => true,
		'header-text'   => false,
	) );

	// Set up the WordPress core custom background feature.
	add_theme_support( 'custom-background', apply_filters( 'panoramic_custom_background_args', array(
		'default-color' => 'ffffff',
		'default-image' => '',
	) ) );
    
    add_theme_support( 'title-tag' );
	add_theme_support( 'woocommerce' );
}
endif; // panoramic_theme_setup
add_action( 'after_setup_theme', 'panoramic_theme_setup' );

/**
 * Register widget area.
 *
 * @link http://codex.wordpress.org/Function_Reference/register_sidebar
 */
function panoramic_widgets_init() {
	register_sidebar( array(
		'name'          => __( 'Sidebar', 'panoramic' ),
		'id'            => 'sidebar-1',
		'description'   => '',
		'before_widget' => '<aside id="%1$s" class="widget %2$s">',
		'after_widget'  => '</aside>',
		'before_title'  => '<h2 class="widget-title">',
		'after_title'   => '</h2>'
	) );
	
	register_sidebar(array(
		'name' => __( 'Footer', 'panoramic' ),
		'id' => 'footer',
        'description' => ''
	));
}
add_action( 'widgets_init', 'panoramic_widgets_init' );

/**
 * Enqueue scripts and styles.
 */
function panoramic_theme_scripts() {
	wp_enqueue_style( 'panoramic-site-title-font-default', '//fonts.googleapis.com/css?family=Kaushan+Script:400', array(), PANORAMIC_THEME_VERSION );
    wp_enqueue_style( 'panoramic-body-font-default', '//fonts.googleapis.com/css?family=Lato:300,300italic,400,400italic,600,600italic,700,700italic', array(), PANORAMIC_THEME_VERSION );
    wp_enqueue_style( 'panoramic-heading-font-default', '//fonts.googleapis.com/css?family=Raleway:500,600,700,100,800,400,300', array(), PANORAMIC_THEME_VERSION );
    
    if ( get_theme_mod( 'panoramic-header-layout', 'panoramic-header-layout-standard' ) == 'panoramic-header-layout-centered' ) {
    	wp_enqueue_style( 'panoramic-header-centered', get_template_directory_uri().'/library/css/header-centered.css', array(), PANORAMIC_THEME_VERSION );
    } else {
    	wp_enqueue_style( 'panoramic-header-standard', get_template_directory_uri().'/library/css/header-standard.css', array(), PANORAMIC_THEME_VERSION );
    }
    
	wp_enqueue_style( 'panoramic-font-awesome', get_template_directory_uri().'/library/fonts/font-awesome/css/font-awesome.css', array(), '4.2.0' );
	wp_enqueue_style( 'panoramic-style', get_stylesheet_uri(), array(), PANORAMIC_THEME_VERSION );
	
	if ( panoramic_is_woocommerce_activated() ) {	
    	wp_enqueue_style( 'panoramic-woocommerce-custom', get_template_directory_uri().'/library/css/woocommerce-custom.css', array(), PANORAMIC_THEME_VERSION );
	}

	wp_enqueue_script( 'panoramic-navigation-js', get_template_directory_uri() . '/library/js/navigation.js', array(), PANORAMIC_THEME_VERSION, true );
	wp_enqueue_script( 'panoramic-caroufredsel-js', get_template_directory_uri() . '/library/js/jquery.carouFredSel-6.2.1-packed.js', array('jquery'), PANORAMIC_THEME_VERSION, true );
	
	wp_enqueue_script( 'panoramic-custom-js', get_template_directory_uri() . '/library/js/custom.js', array('jquery'), PANORAMIC_THEME_VERSION, true );

	wp_enqueue_script( 'panoramic-skip-link-focus-fix-js', get_template_directory_uri() . '/library/js/skip-link-focus-fix.js', array(), PANORAMIC_THEME_VERSION, true );

	if ( is_singular() && comments_open() && get_option( 'thread_comments' ) ) {
		wp_enqueue_script( 'comment-reply' );
	}
}
add_action( 'wp_enqueue_scripts', 'panoramic_theme_scripts' );

// Recommended plugins installer
require_once get_template_directory() . '/library/includes/class-tgm-plugin-activation.php';

/**
 * Custom template tags for this theme.
 */
require get_template_directory() . '/library/includes/template-tags.php';

/**
 * Custom functions that act independently of the theme templates.
 */
require get_template_directory() . '/library/includes/extras.php';

/**
 * Customizer additions.
 */
require get_template_directory() . '/library/includes/customizer.php';

/**
 * Load Jetpack compatibility file.
 */
require get_template_directory() . '/library/includes/jetpack.php';

// Helper library for the theme customizer.
require get_template_directory() . '/customizer/customizer-library/customizer-library.php';

// Define options for the theme customizer.
require get_template_directory() . '/customizer/customizer-options.php';

// Output inline styles based on theme customizer selections.
require get_template_directory() . '/customizer/styles.php';

// Additional filters and actions based on theme customizer selections.
require get_template_directory() . '/customizer/mods.php';

/**
 * Premium Upgrade Page
 */
if ( !class_exists( 'otb_theme_upgrader' ) ) {
	include get_template_directory() . '/upgrade/upgrade.php';
}

/**
 * Enqueue panoramic custom customizer styling.
 */
function panoramic_load_customizer_script() {
    wp_enqueue_script( 'panoramic-customizer-custom-js', get_template_directory_uri() . '/customizer/customizer-library/js/customizer-custom.js', array('jquery'), PANORAMIC_THEME_VERSION, true );

    $upgrade_button = array(
    	'link' => admin_url( 'themes.php?page=premium_upgrade' ),
    	'text' => __( 'Upgrade To Premium &raquo;', 'panoramic' )
    );
    
    wp_localize_script( 'panoramic-customizer-custom-js', 'upgrade_button', $upgrade_button );
    
    wp_enqueue_style( 'panoramic-customizer', get_template_directory_uri() . '/customizer/customizer-library/css/customizer.css' );
}    
add_action( 'customize_controls_enqueue_scripts', 'panoramic_load_customizer_script' );

// Create function to check if WooCommerce exists.
if ( ! function_exists( 'panoramic_is_woocommerce_activated' ) ) :
	function panoramic_is_woocommerce_activated() {
    	if ( class_exists( 'woocommerce' ) ) {
    		return true;
    	} else {
    		return false;
    	}
	}
endif; // panoramic_is_woocommerce_activated

if ( panoramic_is_woocommerce_activated() ) {
    require get_template_directory() . '/library/includes/woocommerce-inc.php';
}

// Add CSS class to body by filter
function panoramic_add_body_class( $classes ) {
	if ( get_theme_mod( 'panoramic-layout-woocommerce-shop-full-width', false ) ) {
		$classes[] = 'panoramic-shop-full-width';
	}

	return $classes;
}
add_filter( 'body_class', 'panoramic_add_body_class' );

// Set the number or products per row
if (!function_exists('panoramic_loop_shop_columns')) {

	function panoramic_loop_shop_columns() {
		if ( get_theme_mod( 'panoramic-layout-woocommerce-shop-full-width', false ) ) {
			return 4;
		} else {
			return 3;
		}
	}

}
add_filter('loop_shop_columns', 'panoramic_loop_shop_columns');

function panoramic_excerpt_length( $length ) {
	return get_theme_mod( 'panoramic-blog-excerpt-length', customizer_library_get_default( 'panoramic-blog-excerpt-length' ) );
}
add_filter( 'excerpt_length', 'panoramic_excerpt_length', 999 );

function panoramic_excerpt_more( $more ) {
	return ' <a class="read-more" href="' . get_permalink( get_the_ID() ) . '">' . wp_kses_post( get_theme_mod( 'panoramic-blog-read-more-text', __('Read More', 'panoramic') ) ) . '</a>';
}
add_filter( 'excerpt_more', 'panoramic_excerpt_more' );

/**
 * Adjust is_home query if panoramic-slider-categories is set
 */
function panoramic_set_blog_queries( $query ) {
    
    $slider_categories = get_theme_mod( 'panoramic-slider-categories', '' );
    
    if ( $slider_categories != '' ) {
    	
    	$is_front_page = ( $query->get('page_id') == get_option('page_on_front') || is_front_page() );
    	
	    if ( count($slider_categories) > 0) {
	        // do not alter the query on wp-admin pages and only alter it if it's the main query
	        if ( !is_admin() && !$is_front_page || !is_admin() && $is_front_page && $query->get('id') != 'slider' ){
                $query->set( 'category__not_in', $slider_categories );
	        }
	    }
	}
	    
}
add_action( 'pre_get_posts', 'panoramic_set_blog_queries' );

function panoramic_filter_recent_posts_widget_parameters( $params ) {

	$slider_categories = get_theme_mod( 'panoramic-slider-categories', '' );

	if ( $slider_categories != '' ) {
		if ( count($slider_categories) > 0) {
			// do not alter the query on wp-admin pages and only alter it if it's the main query
			$params['category__not_in'] = $slider_categories;
		}
	}
	
	return $params;
}
add_filter('widget_posts_args','panoramic_filter_recent_posts_widget_parameters');

/**
 * Adjust the widget categories query if panoramic-slider-categories is set
 */
function panoramic_set_widget_categories_args($args){
	$slider_categories = get_theme_mod( 'panoramic-slider-categories', '' );
	
	if ( $slider_categories != '' ) {
		if ( count($slider_categories) > 0) {
			$exclude = implode(',', $slider_categories);
			$args['exclude'] = $exclude;
		}
	}

	return $args;
}
add_filter('widget_categories_args', 'panoramic_set_widget_categories_args');

function panoramic_set_widget_categories_dropdown_arg($args){
	$slider_categories = get_theme_mod( 'panoramic-slider-categories', '' );

	if ( $slider_categories != '' ) {
		if ( count($slider_categories) > 0) {
			$exclude = implode(',', $slider_categories);
			$args['exclude'] = $exclude;
		}
	}

	return $args;
}
add_filter('widget_categories_dropdown_args', 'panoramic_set_widget_categories_dropdown_arg');

function panoramic_allowed_tags() {
	global $allowedtags;
	$allowedtags["h1"] = array();
	$allowedtags["h2"] = array();
	$allowedtags["h3"] = array();
	$allowedtags["h4"] = array();
	$allowedtags["h5"] = array();
	$allowedtags["h6"] = array();
	$allowedtags["p"] = array();
	$allowedtags["br"] = array();
}
add_action('init', 'panoramic_allowed_tags', 10);

function panoramic_register_required_plugins() {
	
	$plugins = array(
		array(
			'name'      => 'Page Builder by SiteOrigin',
			'slug'      => 'siteorigin-panels',
			'required'  => false
		),
		array(
			'name'      => 'SiteOrigin Widgets Bundle',
			'slug'      => 'so-widgets-bundle',
			'required'  => false
		),
		array(
			'name'      => 'Recent Posts Widget Extended',
			'slug'      => 'recent-posts-widget-extended',
			'required'  => false
		),
		array(
			'name'      => 'SiteOrigin CSS',
			'slug'      => 'so-css',
			'required'  => false
		),
		array(
			'name'      => 'Contact Form 7',
			'slug'      => 'contact-form-7',
			'required'  => false
		),
		array(
			'name'      => 'Breadcrumb NavXT',
			'slug'      => 'breadcrumb-navxt',
			'required'  => false
		),
		array(
			'name'      => 'WooCommerce',
			'slug'      => 'woocommerce',
			'required'  => false
		),
		array(
			'name'      => 'Anti-Spam',
			'slug'      => 'anti-spam',
			'required'  => false
		),
		array(
			'name'      => 'Yoast SEO',
			'slug'      => 'wordpress-seo',
			'required'  => false
		),
	);

	$config = array(
		'id'           => 'panoramic',            // Unique ID for hashing notices for multiple instances of TGMPA.
		'default_path' => get_stylesheet_directory() .'/library/plugins/', // Default absolute path to bundled plugins.
		'menu'         => 'tgmpa-install-plugins', // Menu slug.
		'has_notices'  => true,                    // Show admin notices or not.
		'dismissable'  => true,                    // If false, a user cannot dismiss the nag message.
		'dismiss_msg'  => '',                      // If 'dismissable' is false, this message will be output at top of nag.
		'is_automatic' => false,                    // Automatically activate plugins after installation or not.
		'message'      => ''                       // Message to output right before the plugins table.
	);

	tgmpa( $plugins, $config );
}
add_action( 'tgmpa_register', 'panoramic_register_required_plugins' );
