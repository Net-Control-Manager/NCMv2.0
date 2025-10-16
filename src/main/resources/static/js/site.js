// ===================
// DIALOG BOX CONTROLS
// ===================

$(document).on('click', '.closeModalButton', function() {
    // Find the closest <dialog> ancestor and close it
    $(this).closest('dialog')[0].close();
});