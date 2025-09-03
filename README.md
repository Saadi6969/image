This feature lets users pick an image from their phone or click a new picture, then upload it to Firebase Storage (cloud storage provided by Google).
After uploading, we get the image link (URL) from Firebase and save it in Firebase Realtime Database so we can load it later.
Finally, we use Glide (an image-loading library) to display the image inside the app.

This makes Firebase work like your API — no need to create your own backend server.
