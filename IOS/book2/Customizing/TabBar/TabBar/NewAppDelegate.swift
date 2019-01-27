//
//  NewAppDelegate.swift
//  TabBar
//
//  Created by estgames on 2017. 12. 18..
//  Copyright © 2017년 estgames. All rights reserved.
//

import UIKit
@UIApplicationMain  //어트리뷰트 추가 시스템에 이 클래스가 앱 델리게이트라고 알려준다. 프로젝트에서 하나만 사용해야 한다.
class NewAppDelegate: UIResponder, UIApplicationDelegate {  //앱 델리게이트 역할에 필요한 조건 UIR...상속  UIA... 프로토콜 구현
    var window: UIWindow?   //이름이 window 여야함
    
    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplicationLaunchOptionsKey : Any]? = nil) -> Bool {
        let tbc = UITabBarController()
        tbc.view.backgroundColor = .white
        
        self.window?.rootViewController = tbc
        
        let view01 = ViewController()
        let view02 = SecondViewController()
        let view03 = ThirdViewController()
        
        tbc.setViewControllers([view01, view02, view03], animated: false)
        
        view01.tabBarItem = UITabBarItem(title: "Calendar", image: UIImage(named: "calendar"), selectedImage: nil)
        view02.tabBarItem = UITabBarItem(title: "File", image: UIImage(named: "file-tree"), selectedImage: nil)
        view03.tabBarItem = UITabBarItem(title: "Photo", image: UIImage(named: "photo"), selectedImage: nil)
        
        return true
    }
}
