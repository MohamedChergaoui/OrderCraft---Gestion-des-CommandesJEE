function refreshPage() {
    location.reload(true); // true forces a reload from the server and not from the cache
}

// Use the pageshow event to trigger a refresh when navigating back
window.addEventListener('pageshow', function (event) {
    // Check the persisted property to determine if the page is being restored from the session history
    if (event.persisted) {
        refreshPage();
        console.log("raja")
    }
});