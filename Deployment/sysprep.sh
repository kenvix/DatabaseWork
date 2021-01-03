cp -f /home/aiexaminer/sysctl.conf /etc/sysctl.d/00-networkopts.conf
sysctl -p
systemctl restart systemd-sysctl
ulimit -u 65515
ulimit -n 65515
