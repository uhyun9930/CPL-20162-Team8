/**
 * Panoramic Customizer Custom Functionality
 *
 */
( function( $ ) {
	
	var upgradeButton = '<span class="out_the_box_upgrade"><a href="' + upgrade_button.link + '" class="button" target="_blank">' + upgrade_button.text + '</a></span>';	
	
    $('.preview-notice').prepend(upgradeButton);
    
    $( window ).load( function() {
    	// Show / Hide header options
        var headerLayout = $( '#customize-control-panoramic-header-layout select' ).val();
        panoramic_toggle_header_options( headerLayout );
        
        $( '#customize-control-panoramic-header-layout select' ).on( 'change', function() {
        	headerLayout = $( this ).val();
        	panoramic_toggle_header_options( headerLayout );
        } );
        
        function panoramic_toggle_header_options( headerLayout ) {
            if ( headerLayout == 'panoramic-header-layout-standard' ) {
                $( '#customize-control-panoramic-show-header-top-bar' ).hide();
                
            } else if ( headerLayout == 'panoramic-header-layout-centered' ) {
                $( '#customize-control-panoramic-show-header-top-bar' ).show();
                
            }
        }
    	
    	// Show / Hide slider options
        var sliderType = $( '#customize-control-panoramic-slider-type select' ).val();
        panoramic_toggle_slider_options( sliderType );
        
        $( '#customize-control-panoramic-slider-type select' ).on( 'change', function() {
        	sliderType = $( this ).val();
        	panoramic_toggle_slider_options( sliderType );
        } );
        
        function panoramic_toggle_slider_options( sliderType ) {
            if ( sliderType == 'panoramic-slider-default' ) {
            	$( '#customize-control-panoramic-slider-plugin-shortcode' ).hide();
                $( '#customize-control-panoramic-slider-categories' ).show();
                $( '#customize-control-panoramic-slider-transition-speed' ).show();
                
            } else if ( sliderType == 'panoramic-slider-plugin' ) {
                $( '#customize-control-panoramic-slider-categories' ).hide();
                $( '#customize-control-panoramic-slider-transition-speed' ).hide();
                $( '#customize-control-panoramic-slider-plugin-shortcode' ).show();
                
            } else {
                $( '#customize-control-panoramic-slider-categories' ).hide();
                $( '#customize-control-panoramic-slider-transition-speed' ).hide();
                $( '#customize-control-panoramic-slider-plugin-shortcode' ).hide();
                
            }
        }

    	// Show / Hide blog options
        var blogArchiveLayout = $( '#customize-control-panoramic-blog-archive-layout select' ).val();
        panoramic_toggle_blog_options( blogArchiveLayout );
        
        $( '#customize-control-panoramic-blog-archive-layout select' ).on( 'change', function() {
        	blogArchiveLayout = $( this ).val();
        	panoramic_toggle_blog_options( blogArchiveLayout );
        } );
        
        function panoramic_toggle_blog_options( blogArchiveLayout ) {
            if ( blogArchiveLayout == 'panoramic-blog-archive-layout-full' ) {
                $( '#customize-control-panoramic-blog-excerpt-length' ).hide();
                $( '#customize-control-panoramic-blog-read-more-text' ).hide();
                
            } else if ( blogArchiveLayout == 'panoramic-blog-archive-layout-excerpt' ) {
                $( '#customize-control-panoramic-blog-excerpt-length' ).show();
                $( '#customize-control-panoramic-blog-read-more-text' ).show();
                
            }
        }        
        
    } );
    
} )( jQuery );