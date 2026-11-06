import UIKit
import SwiftUI
import ComposeApp
import CoreLocation
import UserNotifications

final class PermissionRequester: NSObject, ObservableObject, CLLocationManagerDelegate {
    private let locationManager = CLLocationManager()
    private var hasRequestedPermissions = false

    func requestPermissions() {
        guard !hasRequestedPermissions else { return }
        hasRequestedPermissions = true
        locationManager.delegate = self
        locationManager.requestWhenInUseAuthorization()
        UNUserNotificationCenter.current().requestAuthorization(options: [.alert, .badge, .sound]) { _, _ in }
    }
}

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        MainViewControllerKt.MainViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ContentView: View {
    @StateObject private var permissionRequester = PermissionRequester()

    var body: some View {
        ComposeView()
            .ignoresSafeArea()
            .onAppear { permissionRequester.requestPermissions() }
    }
}



