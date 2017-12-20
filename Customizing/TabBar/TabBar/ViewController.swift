//
//  ViewController.swift
//  TabBar
//
//  Created by estgames on 2017. 12. 18..
//  Copyright © 2017년 estgames. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        let title = UILabel(frame: CGRect(x: 0, y: 100, width: 100, height: 30))
        
        title.text = "첫번째 탭"
        title.textColor = UIColor.red
        title.textAlignment = .center
        title.font = UIFont.boldSystemFont(ofSize: 14)
        
        title.sizeToFit()
        
        title.center.x = self.view.frame.width / 2
        
        self.view.addSubview(title)
        
//        self.tabBarItem.image = UIImage(named: "calendar")
//        self.tabBarItem.title = "Calendar"
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    override func touchesEnded(_ touches: Set<UITouch>, with event: UIEvent?) {
        //UIViewController의 상위 클래스 UIResponder 에 화면 터치와 관련된 메소드가 정의 되어 있다.
        //화면에서 터치가 끝났을 때 호출되는 메소드
        let tabBar = self.tabBarController?.tabBar
        //tabBar?.isHidden = (tabBar?.isHidden == true) ? false : true    //탭바 보이고 안보이게
        
        UIView.animate(withDuration: TimeInterval(0.15)) {
            tabBar?.alpha = (tabBar?.alpha == 0 ? 1 : 0)
        }
    }

}

