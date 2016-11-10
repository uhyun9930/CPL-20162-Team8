<?php
/**
 * Defines customizer options
 *
 * @package Customizer Library Demo
 */

function panoramic_customizer_library_options() {
	// Theme defaults
	$primary_color = '#006489';
	$secondary_color = '#3F84A4';
	$footer_color = '#EAF1F7';
    
    $body_font_color = '#58585A';
    $heading_font_color = '#006489';

	// Stores all the controls that will be added
	$options = array();

	// Stores all the sections to be added
	$sections = array();

	// Adds the sections to the $options array
	$options['sections'] = $sections;
	
	// Site Identity
	$section = 'title_tagline';
	
	$sections[] = array(
		'id' => $section,
		'title' => __( 'Site Identity', 'panoramic' ),
		'priority' => '25'
	);
	
	if ( ! function_exists( 'has_custom_logo' ) ) {	
		$options['panoramic-logo'] = array(
			'id' => 'panoramic-logo',
			'label'   => __( 'Logo', 'panoramic' ),
			'section' => $section,
			'type'    => 'image'
		);	
	}
	
    // Layout Settings
    $section = 'panoramic-layout';

    $sections[] = array(
        'id' => $section,
        'title' => __( 'Layout', 'panoramic' ),
        'priority' => '30'
    );
    
    $options['panoramic-layout-woocommerce-shop-full-width'] = array(
    	'id' => 'panoramic-layout-woocommerce-shop-full-width',
    	'label'   => __( 'Full width WooCommerce Shop page', 'panoramic' ),
    	'section' => $section,
    	'type'    => 'checkbox',
    	'default' => 0
    );
        
    // Header Settings
    $section = 'panoramic-header';
    
    $sections[] = array(
    	'id' => $section,
    	'title' => __( 'Header', 'panoramic' ),
    	'priority' => '35'
    );
    $choices = array(
    	'panoramic-header-layout-standard' => 'Standard',
    	'panoramic-header-layout-centered' => 'Centered'
    );
    $options['panoramic-header-layout'] = array(
    	'id' => 'panoramic-header-layout',
    	'label'   => __( 'Layout', 'panoramic' ),
    	'section' => $section,
    	'type'    => 'select',
    	'choices' => $choices,
    	'default' => 'panoramic-header-layout-standard'
    );
        
    $options['panoramic-show-header-top-bar'] = array(
    	'id' => 'panoramic-show-header-top-bar',
    	'label'   => __( 'Show Top Bar', 'panoramic' ),
    	'section' => $section,
    	'type'    => 'checkbox',
    	'default' => 1
    );
    $options['panoramic-header-info-text'] = array(
    	'id' => 'panoramic-header-info-text',
    	'label'   => __( 'Info Text', 'panoramic' ),
    	'section' => $section,
    	'type'    => 'text',
    	'default' => __( '<strong><em>CALL US:</em></strong> 555-PANORAMIC', 'panoramic')
    );
    $options['panoramic-header-shop-links'] = array(
    	'id' => 'panoramic-header-shop-links',
    	'label'   => __( 'Shop Links', 'panoramic' ),
    	'section' => $section,
    	'type'    => 'checkbox',
    	'default' => 1,
		'description' => __( 'Display the My Account and Checkout links when WooCommerce is active.', 'panoramic' )
    );
    $options['panoramic-header-search'] = array(
    	'id' => 'panoramic-header-search',
    	'label'   => __( 'Show Search', 'panoramic' ),
    	'section' => $section,
    	'type'    => 'checkbox',
    	'default' => 1
    );

    
    // Social Settings
    $section = 'panoramic-social';
    
    $sections[] = array(
    	'id' => $section,
    	'title' => __( 'Social Media Links', 'panoramic' ),
    	'priority' => '35'
    );
    
    $options['panoramic-social-email'] = array(
    	'id' => 'panoramic-social-email',
    	'label'   => __( 'Email Address', 'panoramic' ),
    	'section' => $section,
    	'type'    => 'text'
    );
    $options['panoramic-social-skype'] = array(
    	'id' => 'panoramic-social-skype',
    	'label'   => __( 'Skype Name', 'panoramic' ),
    	'section' => $section,
    	'type'    => 'text'
    );
    
    $options['panoramic-social-tumblr'] = array(
    	'id' => 'panoramic-social-tumblr',
    	'label'   => __( 'Tumblr', 'panoramic' ),
    	'section' => $section,
    	'type'    => 'text'
    );
    $options['panoramic-social-flickr'] = array(
    	'id' => 'panoramic-social-flickr',
    	'label'   => __( 'Flickr', 'panoramic' ),
    	'section' => $section,
    	'type'    => 'text'
    );
    
    
    // Search Settings
    $section = 'panoramic-search';
    
    $sections[] = array(
    	'id' => $section,
    	'title' => __( 'Search', 'panoramic' ),
    	'priority' => '35'
    );
    
    $options['panoramic-search-placeholder-text'] = array(
    	'id' => 'panoramic-search-placeholder-text',
    	'label'   => __( 'Default Search Input Text', 'panoramic' ),
    	'section' => $section,
    	'type'    => 'text',
    	'default' => __( 'Search...', 'panoramic' )
    );    

    $options['panoramic-website-text-no-search-results-heading'] = array(
    	'id' => 'panoramic-website-text-no-search-results-heading',
    	'label'   => __( 'No Search Results Heading', 'panoramic' ),
    	'section' => $section,
    	'type'    => 'text',
    	'default' => __( 'Nothing Found!', 'panoramic')
    );
    $options['panoramic-website-text-no-search-results-text'] = array(
    	'id' => 'panoramic-website-text-no-search-results-text',
    	'label'   => __( 'No Search Results Message', 'panoramic' ),
    	'section' => $section,
    	'type'    => 'textarea',
    	'default' => __( 'Sorry, but nothing matched your search terms. Please try again with some different keywords.', 'panoramic')
    );
    
    
    // Mobile Menu Settings
    $section = 'panoramic-mobile-menu';
    
    $sections[] = array(
    	'id' => $section,
    	'title' => __( 'Mobile Menu', 'panoramic' ),
    	'priority' => '35'
    );
    
    
    // Slider Settings
    $section = 'panoramic-slider';

    $sections[] = array(
        'id' => $section,
        'title' => __( 'Slider', 'panoramic' ),
        'priority' => '35'
    );
    
    $choices = array(
        'panoramic-slider-default' => 'Default Slider',
        'panoramic-slider-plugin' => 'Slider Plugin',
        'panoramic-no-slider' => 'None'
    );
    $options['panoramic-slider-type'] = array(
        'id' => 'panoramic-slider-type',
        'label'   => __( 'Choose a Slider', 'panoramic' ),
        'section' => $section,
        'type'    => 'select',
        'choices' => $choices,
        'default' => 'panoramic-no-slider'
    );
	
	$options['panoramic-slider-categories'] = array(
		'id' => 'panoramic-slider-categories',
		'label'   => __( 'Select Categories', 'panoramic' ),
		'section' => $section,
		'type'    => 'dropdown-categories',
		'description' => __( 'Select the categories of the posts you want to display in the slider. The featured image will be the slide image and the post content will display over it. Hold down the Ctrl (windows) / Command (Mac) button to select multiple categories.', 'panoramic' )
	);
	
    $options['panoramic-slider-transition-speed'] = array(
    	'id' => 'panoramic-slider-transition-speed',
    	'label'   => __( 'Slide Transition Speed', 'panoramic' ),
    	'section' => $section,
    	'type'    => 'text',
    	'default' => 450,
    	'description' => __( 'The speed it takes to transition between slides in milliseconds. 1000 milliseconds equals 1 second.', 'panoramic' )
    );
    
    $options['panoramic-slider-plugin-shortcode'] = array(
    	'id' => 'panoramic-slider-plugin-shortcode',
    	'label'   => __( 'Slider Shortcode', 'panoramic' ),
    	'section' => $section,
    	'type'    => 'text',
    	'description' => __( 'Enter the shortcode given by the slider plugin you\'re using.', 'panoramic' )
    );

    
	// Header Image
	$section = 'header_image';
	
	$sections[] = array(
		'id' => $section,
		'title' => __( 'Header Image', 'panoramic' ),
		'priority' => '35'
	);

    $options['panoramic-header-image-text'] = array(
		'id' => 'panoramic-header-image-text',
        'label'   => __( 'Text', 'panoramic' ),
        'section' => $section,
        'type'    => 'textarea'
    );
	
    
	// Colors
    $section = 'colors';
    $font_choices = customizer_library_get_font_choices();
    
    $sections[] = array(
    	'id' => $section,
    	'title' => __( 'Colors', 'panoramic' ),
    	'priority' => '25'
    );    

	$options['panoramic-primary-color'] = array(
		'id' => 'panoramic-primary-color',
		'label'   => __( 'Primary Color', 'panoramic' ),
		'section' => $section,
		'type'    => 'color',
		'default' => $primary_color
	);
	$options['panoramic-secondary-color'] = array(
		'id' => 'panoramic-secondary-color',
		'label'   => __( 'Secondary Color', 'panoramic' ),
		'section' => $section,
		'type'    => 'color',
		'default' => $secondary_color
	);
    
    $options['panoramic-footer-color'] = array(
    	'id' => 'panoramic-footer-color',
    	'label'   => __( 'Footer Color', 'panoramic' ),
    	'section' => $section,
    	'type'    => 'color',
    	'default' => $footer_color
    );
    
    
    // Font Settings
	$section = 'panoramic-fonts';
    $font_choices = customizer_library_get_font_choices();
    
    $sections[] = array(
    	'id' => $section,
    	'title' => __( 'Fonts', 'panoramic' ),
    	'priority' => '25'
    );
    
    $options['panoramic-site-title-font'] = array(
    	'id' => 'panoramic-site-title-font',
    	'label'   => __( 'Site Title Font', 'panoramic' ),
    	'section' => $section,
    	'type'    => 'select',
    	'choices' => $font_choices,
    	'default' => 'Kaushan Script'
    );
    
    $options['panoramic-heading-font'] = array(
    	'id' => 'panoramic-heading-font',
    	'label'   => __( 'Heading Font', 'panoramic' ),
    	'section' => $section,
    	'type'    => 'select',
    	'choices' => $font_choices,
    	'default' => 'Raleway'
    );
    $options['panoramic-heading-font-color'] = array(
    	'id' => 'panoramic-heading-font-color',
    	'label'   => __( 'Heading Font Color', 'panoramic' ),
    	'section' => $section,
    	'type'    => 'color',
    	'default' => $heading_font_color
    );
    
    $options['panoramic-body-font'] = array(
    	'id' => 'panoramic-body-font',
    	'label'   => __( 'Body Font', 'panoramic' ),
    	'section' => $section,
    	'type'    => 'select',
    	'choices' => $font_choices,
    	'default' => 'Lato'
    );
    $options['panoramic-body-font-color'] = array(
    	'id' => 'panoramic-body-font-color',
    	'label'   => __( 'Body Font Color', 'panoramic' ),
    	'section' => $section,
    	'type'    => 'color',
    	'default' => $body_font_color
    );
    
    
    // Blog Settings
    $section = 'panoramic-blog';

    $sections[] = array(
        'id' => $section,
        'title' => __( 'Blog', 'panoramic' ),
        'priority' => '50'
    );

    $choices = array(
		'panoramic-blog-archive-layout-full' => 'Full Post',
		'panoramic-blog-archive-layout-excerpt' => 'Post Excerpt'
    );
    $options['panoramic-blog-archive-layout'] = array(
        'id' => 'panoramic-blog-archive-layout',
        'label'   => __( 'Archive Layout', 'panoramic' ),
        'section' => $section,
        'type'    => 'select',
        'choices' => $choices,
        'default' => 'panoramic-blog-archive-layout-full'
    );
    
    $options['panoramic-blog-excerpt-length'] = array(
    	'id' => 'panoramic-blog-excerpt-length',
    	'label'   => __( 'Excerpt Length', 'panoramic' ),
    	'section' => $section,
    	'type'    => 'text',
    	'default' => 55
    );
    
    $options['panoramic-blog-read-more-text'] = array(
    	'id' => 'panoramic-blog-read-more-text',
    	'label'   => __( 'Read More Text', 'panoramic' ),
    	'section' => $section,
    	'type'    => 'text',
    	'default' => 'Read More'
    );
    
    // Site Text Settings
    $section = 'panoramic-website';

    $sections[] = array(
        'id' => $section,
        'title' => __( 'Website Text', 'panoramic' ),
        'priority' => '50'
    );
    $options['panoramic-website-text-404-page-heading'] = array(
    	'id' => 'panoramic-website-text-404-page-heading',
    	'label'   => __( '404 Page Heading', 'panoramic' ),
    	'section' => $section,
    	'type'    => 'text',
    	'default' => __( '404!', 'panoramic')
    );
    $options['panoramic-website-text-404-page-text'] = array(
    	'id' => 'panoramic-website-text-404-page-text',
    	'label'   => __( '404 Page Message', 'panoramic' ),
    	'section' => $section,
    	'type'    => 'textarea',
    	'default' => __( 'The page you were looking for cannot be found!', 'panoramic')
    );

        
	// Adds the sections to the $options array
	$options['sections'] = $sections;

	$customizer_library = Customizer_Library::Instance();
	$customizer_library->add_options( $options );

	// To delete custom mods use: customizer_library_remove_theme_mods();

}
add_action( 'init', 'panoramic_customizer_library_options' );
